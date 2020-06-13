(ns app.views
  (:require [reagent.core :as reagent :refer [atom]]
            [swiper :as Swiper]))

(defn swiper [classone pagone]
  (if (< js/window.screen.width 800)
    (new Swiper (str classone), (clj->js {:slidesPerView "auto" :centeredSlides true :spaceBetween -30 :pagination {:el (str pagone)}}))
    (new Swiper (str classone), (clj->js {:slidesPerView "5" :centeredSlides false :spaceBetween 0 :pagination {:el (str pagone)}}))))

(defn division [img title description]
  [:div.swiper-slide
   [:div.work-card
    [:img {:class [img] :src (str "/images/" img ".svg")}]
    [:div.card-bg
     [:h4.card-title title]
     [:div.card-description
      (for [p description]
        [:p p])]]]])

(defn member [img title name description social]
  [:div.swiper-slide
   [:div.work-card.w2
    [:img.bruno {:src (str "/images/" img ".jpg")}]
    [:div.card-bg.card-bg-flex
     [:h4.card-title title]
     [:div.card-description
      (for [p description]
        [:p p])]
     [:div.card-name
      [:p name]]
     [:div.card-social
      (for [platform social]
        [:a {:class ["social-icon" (first platform)] :href (second platform) :target "_blank"}])]]]])

(defn app []
  (reagent/create-class
   {:component-did-mount (fn [this] (swiper ".swiper-container" ".swiper-pagination") (swiper ".s2" "sp2"))
    :reagent-render
    (fn []
      [:div.custom-homepage-wrapper
       [:img.left-circuit {:src "/images/left-circuit.svg"}]
       [:img.right-circuit {:src "/images/right-circuit.svg"}]
       [:div.title-wrapper
        [:h1.zgen "ZGEN"]
        [:h2.kibernetika "KIBERNETIKA"]
        [:p "No matter how many times we fail, we're the generation of progress."]]

       [:div.container-z
        [:div.subtitle-wrapper
         [:h3.work-title "DIVISIONS"]
         [:p {:style {:margin-bottom "24px"}}
          [:b "Our work should support and specialize on the needs of the next generations."]]]
        [:div.swiper-container
         [:div.swiper-wrapper
          [division "ai" "AI ENGINEERING"
           ["Creating something with intelligence is not unusual for us."
            "From simple automations to multi-layer neural networks:"
            "We build our custom solutions from a mix of deep learning, logical programming and low-level language designs."]]

          [division "ether" "DIGITAL ASSET MANAGEMENT"
           ["Redefining investments is a massive goal we followed over the past decade."
            "With +7 years of investment experiences in online game assets, domain addresses and cryptocurrencies,"
            "our portfolio is one of the most unique in Hungary."]]

          [division "webdev" "WEB BUILDING"
           ["We have a long professional history in web-development and cloud computing."
            "+100 web-applications and onepagers serve our clients and the ZGEN ecosystem."
            "From 2017 we have built a custom application creator platform and cloud infrastructure."]]

          [division "esport" "ESPORT EVENTS"
           ["We believe online gaming is a new form of connection between friends."
            "Esport is not only for the top players: our community is forged through gaming, the prize is only makes the cherry on top of the cake."
            "Meet you at our next League!"]]

          [division "education" "EDUCATION & MENTORING"
           ["We organize exclusive programming courses for free on a weekly basis.."
            "One of our main goals with ZGEN is to create a platform where we fund projects of talented guild members and help them bootstrap their ventures."]]]
         [:div.swiper-pagination]]]

       [:div.container-z.last-cont
        [:div.subtitle-wrapper
         [:h3.leadership-title "THE COUNCIL"]
         [:p "Leadership should include generation Z members only."]]
        [:div.swiper-container.s2
         [:div.swiper-wrapper
          [member "bruno" "OPERATIONS" "Zawiasa Brúnó Márton"
           ["Bruno is the all seeing eye of ZGEN and its associates, his natural leader abilities and consistency make him a perfect Chief Operating Officer."
            "He is the co-founder of sulibot.hu, a popular educational chatbot solution."]
           [["linkedin" "https://www.linkedin.com/in/bruno-z-411656141/"]
            ["telegram" "/"]]]

          [member "berci" "TECHNOLOGY" "Zawias Bernát Barnabás"
           ["Bernat is just as precise as his end products."
            "He could create robots from anything which qualifies him as our Chief Technology Officer."
            "When he doesn't do that, he plays darts."]]

          [member "samu" "RELATIONS" "Kálló Sámuel"
           ["Samuel has unmatched abilities to read, understand and learn things."
            "He is an organizer of MCC Debate also has written for prominent hungarian newspapers since his early years in university."]
           [["linkedin" "https://www.linkedin.com/in/s%C3%A1muel-k%C3%A1ll%C3%B3-975428152/"]]]

          [member "aron" "INVESTMENT" "Zawiasa Róbert Áron"
           ["Robert made his way into the investment world early in his career as an early adopter of cryptocurrencies."
            "He is responsible for company strategy and investor relationships as the Chief Investment Officer."]
           [["linkedin" "https://www.linkedin.com/in/zawiasa/"]
            ["twitter" "https://twitter.com/aaronpowered"]
            ["telegram" "/"]]]]

         [:div.swiper-pagination.sp2]]]])}))
