(ns app.views
  (:require [reagent.core :as reagent :refer [atom]]
            [swiper :as Swiper]))

(defn swiper
  [classone pagone]
  (if
    (< js/window.screen.width 800)
    (new Swiper (str classone), (clj->js {:slidesPerView "auto" :centeredSlides true :spaceBetween -30 :pagination {:el (str pagone)}}))
    (new Swiper (str classone), (clj->js {:slidesPerView "5" :centeredSlides false :spaceBetween 0 :pagination {:el (str pagone)}}))))

(defn app []
      (reagent/create-class
        {:component-did-mount (fn [this] (swiper ".swiper-container" ".swiper-pagination") (swiper ".s2" "sp2"))
         :reagent-render
         (fn []
          [:div.custom-homepage-wrapper
             [:img.left-circuit {:src "https://zgen.hu/uploads/default/original/1X/0267237241ffe2608d1de65bfe0be22d428c6d02.svg"}]
             [:img.right-circuit {:src "https://zgen.hu/uploads/default/original/1X/86f49aa411dad8794e619ed68c0274fab208762b.svg"}]
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
                [:div.swiper-slide
                 [:div.work-card
                  [:img.ai {:src "https://zgen.hu/uploads/default/original/1X/78c8ad230ae90bfc766b16ffb95c8423023c1d75.svg"}]
                  [:div.card-bg
                   [:h4.card-title "AI ENGINEERING"]
                   [:div.card-desc-box
                    [:p "Creating something with intelligence is not unusual for us."]
                    [:p "From simple automations to multi-layer neural networks:"]
                    [:p "We build our custom solutions from a mix of deep learning, logical programming and low-level language designs."]]]]]
                [:div.swiper-slide
                 [:div.work-card
                  [:img.ether {:src "https://zgen.hu/uploads/default/original/1X/841c2425e7c16284dfd95fda626523af631daf17.svg"}]
                  [:div.card-bg
                   [:h4.card-title "DIGITAL ASSET MANAGEMENT"]
                   [:div.card-desc-box
                    [:p "Redefining investments is a massive goal we followed over the past decade."]
                    [:p "With +7 years of investment experiences in online game assets, domain addresses and cryptocurrencies,"]
                    [:p "our portfolio is one of the most unique in Hungary."]]]]]
                [:div.swiper-slide
                 [:div.work-card
                  [:img.webdev {:src "https://zgen.hu/uploads/default/original/1X/68563858f477d54559a0f438e61ca73468b09649.svg"}]
                  [:div.card-bg
                   [:h4.card-title "WEB BUILDING"]
                   [:div.card-desc-box
                    [:p "We have a long professional history in web-development and cloud computing."]
                    [:p "+100 web-applications and onepagers serve our clients and the ZGEN ecosystem."]
                    [:p "From 2017 we have built a custom application creator platform and cloud infrastructure."]]]]]
                [:div.swiper-slide
                 [:div.work-card
                  [:img.esport {:src "https://zgen.hu/uploads/default/original/1X/b5cf93716ff53b5218eea9017d30100d116c9a64.svg"}]
                  [:div.card-bg
                   [:h4.card-title "ESPORT EVENTS"]
                   [:div.card-desc-box
                    [:p "We believe online gaming is a new form of connection between friends."]
                    [:p "Esport is not only for the top players: our community is forged through gaming, the prize is only makes the cherry on top of the cake."]
                    [:p "Meet you at our next League!"]]]]]
                [:div.swiper-slide
                 [:div.work-card
                  [:img.education {:src "https://zgen.hu/uploads/default/original/1X/087326bf5a631d944ee87462fcf36a2fd0ecafdd.svg"}]
                  [:div.card-bg
                   [:h4.card-title "EDUCATION & MENTORING"]
                   [:div.card-desc-box
                    [:p "We organize exclusive programming courses for free on a weekly basis.."]
                    [:p "One of our main goals with ZGEN is to create a platform where we fund projects of talented guild members and help them bootstrap their ventures."]]]]]]
               [:div.swiper-pagination]]]
           [:div.container-z.last-cont
              [:div.subtitle-wrapper
               [:h3.leadership-title "THE COUNCIL"]
               [:p
                [:b "Rule 2:"]
                "Leadership should include generation Z members only."]]
             [:div.swiper-container.s2
              [:div.swiper-wrapper
               [:div.swiper-slide
                [:div.work-card.w2
                 [:img.bruno {:src "https://zgen.hu/uploads/default/original/1X/f523474b2548ab1f52a181e69046e2b457fd9992.jpg"}]
                 [:div.card-bg.card-bg-flex
                    [:h4.card-title "OPERATIONS"]
                    [:div.card-desc-box
                     [:p "Bruno is the all seeing eye of ZGEN and its associates, his natural leader abilities and consistency make him a perfect Chief Operating Officer."]
                     [:p "He is the co-founder of "
                      [:a {:href "https://sulibot.hu" :target "_blank" :style {:color "black" :font-weight "800"}} "Sulibot"]
                      ", a popular educational chatbot solution."]]
                    [:div.card-name
                     [:a.fab.fa-facebook.fa-3x {:href "https://www.facebook.com/zawiasa.bruno" :target "_blank"}]
                     [:a.fab.fa-linkedin.fa-3x {:href "https://www.linkedin.com/in/bruno-z-411656141/" :target "_blank"}]]]]]
               [:div.swiper-slide
                [:div.work-card.w2
                 [:img.berci {:src "https://zgen.hu/uploads/default/original/1X/cf2f5695e44a32256d0503433862116004be9247.jpg"}]
                 [:div.card-bg.card-bg-flex
                    [:h4.card-title "TECHNOLOGY"]
                    [:div.card-desc-box
                     [:p "Bernat is just as precise as his end products."]
                     [:p "He could create robots from anything which qualifies him as our Chief Technology Officer."]
                     [:p "When he doesn't do that, he plays darts."]]
                  [:div.card-name
                   [:a.fab.fa-facebook.fa-3x {:href "https://www.facebook.com/bernat.zawiasa" :target "_blank"}]]]]]
               [:div.swiper-slide
                [:div.work-card.w2
                 [:img.samu {:src "https://zgen.hu/uploads/default/original/1X/7d45caa7275933223c1c8a6335784875c63cd81a.jpg"}]
                 [:div.card-bg.card-bg-flex
                    [:h4.card-title "RELATIONS"]
                    [:div.card-desc-box
                     [:p "Samuel has unmatched abilities to read, understand and learn things."]
                     [:p "He is an organizer of "
                      [:a {:href "https://www.facebook.com/mccdebate/" :target "_blank" :style {:color "black" :font-weight "800"}} "MCC Debate"]]
                     [:p "also has written for prominent hungarian newspapers since his early years in university."]]
                  [:div.card-name
                   [:a.fab.fa-facebook.fa-3x {:href "https://www.facebook.com/samuel.kallo.49" :target "_blank"}]
                   [:a.fab.fa-linkedin.fa-3x {:href "https://www.linkedin.com/in/s%C3%A1muel-k%C3%A1ll%C3%B3-975428152/" :target "_blank"}]]]]]
               [:div.swiper-slide
                [:div.work-card.w2
                 [:img.aron {:src "https://zgen.hu/uploads/default/original/1X/f624aace4d9974b95ff6f66aaee4d14fdbb8c5ee.jpg"}]
                 [:div.card-bg.card-bg-flex
                    [:h4.card-title "INVESTMENT"]
                    [:div.card-desc-box
                     [:p "Robert made his way into the investment world early in his career as an early adopter of cryptocurrencies."]
                     [:p "He is responsible for company strategy and investor relationships as the Chief Investment Officer."]]
                  [:div.card-name
                   [:a.fab.fa-facebook.fa-3x {:href "https://www.facebook.com/aaronpowered" :target "_blank"}]
                   [:a.fab.fa-linkedin.fa-3x {:href "https://www.linkedin.com/in/zawiasa/" :target "_blank"}]
                   [:a.fab.fa-twitter.fa-3x {:href "https://twitter.com/aaronpowered" :target "_blank"}]]]]]]
              [:div.swiper-pagination.sp2]]]])}))
