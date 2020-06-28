(ns app.dynamicSwipers
  (:require [reagent.core :as reagent :refer [atom]]
            [swiper :as Swiper]))

(def mainSwiper nil)
(def targetsSwiper nil)

(def mainSwiper_breakpoint (.matchMedia js/window "(min-width:1200px) and (min-height: 795px) and (max-height: 1100px)"))
(def targetsSwiper_breakpoint (.matchMedia js/window "(max-width:1199px)"))

(def enable_mainSwiper
  (fn []
    (set! mainSwiper
      (new Swiper "#mainSwiper",
        (clj->js {:slidesPerView 1
                  :direction "vertical"
                  :spaceBetween 0
                  :mousewheel true
                  :simulateTouch false
                  :keyboard {:enabled true}
                  :hashNavigation {:watchState true}
                  :pagination {:el "#mainPagination"
                               :clickable true
                               :renderBullet
                                (fn [index className]
                                  (str "<div class=\"" className "\">"
                                         "<span>"
                                            (get ["About" "Targets" "Partners" "Products" "Members"] index)
                                         "</span>"
                                       "</div>"))}})))))

(def enable_targetsSwiper
  (fn []
    (set! targetsSwiper
      (new Swiper "#targetsSwiper", (clj->js {:slidesPerView 1
                                              :centeredSlides true
                                              :grabCursor true
                                              :spaceBetween -40
                                              :pagination {:el ".swiper-pagination"}
                                              :breakpoints {:576 {:slidesPerView 2
                                                                  :centeredSlides false
                                                                  :spaceBetween 35}
                                                            :992 {:slidesPerView 3
                                                                  :centeredSlides false
                                                                  :spaceBetween 35}}})))))

(def mainSwiper_breakpointChecker
  (fn []
    (cond
      (= (.-matches mainSwiper_breakpoint) true) (enable_mainSwiper)
      (= (.-matches mainSwiper_breakpoint) false) (when (not= mainSwiper nil)
                                                    (.destroy mainSwiper true true))
      :else nil)))

(def targetsSwiper_breakpointChecker
  (fn []
    (cond
      (= (.-matches targetsSwiper_breakpoint) true) (enable_targetsSwiper)
      (= (.-matches targetsSwiper_breakpoint) false) (when (not= targetsSwiper nil)
                                                      (.destroy targetsSwiper true true))
      :else nil)))

(.addListener mainSwiper_breakpoint mainSwiper_breakpointChecker)
(.addListener targetsSwiper_breakpoint targetsSwiper_breakpointChecker)        
