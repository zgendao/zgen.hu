(ns app.views
  (:require [reagent.core :as reagent :refer [atom]]
            [swiper :as Swiper]))

(defn swiper
  [classone classtwo]
  (new Swiper (str classone), (clj->js {:slidesPerView "5" :centeredSlides "false" :spaceBetween "0" :pagination ".swiper-pagination" :nextEl ".swiper-button-next" :prevEl ".swiper-button-prev" :scrollbar ".swiper-scrollbar" :setTranslate "0"}))
  (new Swiper (str classtwo), (clj->js {:slidesPerView "5" :centeredSlides "false" :spaceBetween "0" :pagination {:el ".swiper-pagination"} :navigation {:nextEl ".swiper-button-next" :prevEl ".swiper-button-prev"} :scrollbar {:el ".swiper-scrollbar"}})))

(defn app []
      (reagent/create-class
        {:component-did-mount (fn [this] (swiper ".swiper-container" ".s2"))
         :reagent-render
         (fn []
           [:div.swiper-container
            [:div.swiper-wrapper
             [:div.swiper-slide "Elso"]
             [:div.swiper-slide "Masodik"]]])}))
