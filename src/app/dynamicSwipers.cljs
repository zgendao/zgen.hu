(ns app.dynamicSwipers
  (:require [reagent.core :as reagent :refer [atom]]
            [swiper :as Swiper]))

(def breakpoint (.matchMedia js/window "(min-width:1200px) and (min-height: 795px) and (max-height: 1100px)"))

(def mainSwiper nil)
(def targetsSwiper nil)

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

(def breakpointChecker
  (fn []
    (cond
      (= (.-matches breakpoint) true) (do (when (not= targetsSwiper nil)
                                            (.destroy targetsSwiper true true))
                                          (enable_mainSwiper))
      (= (.-matches breakpoint) false) (do (when (not= mainSwiper nil)
                                             (.destroy mainSwiper true true))
                                           (enable_targetsSwiper))
      :else nil)))

(.addListener breakpoint breakpointChecker)        
