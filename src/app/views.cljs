(ns app.views
  (:require [reagent.core :as reagent :refer [atom]]
            [app.dynamicSwipers :refer [mainSwiper_breakpointChecker
                                        targetsSwiper_breakpointChecker]]))  

(defn section-title [title]
  [:div.section-title
    [:h2 title]
    [:hr]])

(defn social-icon [platform url size]
  [:a {:href url :target "_blank"}
    [:img {:src (str "/images/social/" platform ".svg") :width size :height size}]])

(defn division [img title description]
  [:div.swiper-slide
   [:div.card
    [:img {:class [img] :src (str "/images/targets/" img ".svg")}]
    [:div.card__content
     [:h5.card__title title]
     [:div.card__description.card__description--smaller
      (for [p description]
        [:p p])]]]])

(defn partner [img title color description]
  [:div.partner
    [:div.partner__brand {:style {:background color}}
      [:img {:src (str "/images/partners/" img ".svg") :width "20" :height "20"}]
      [:h3 title]]
    [:p.partner__desc description]])

(defn product [img title color description url]
  [:div.product.card {:style {:border-color color :background-color (str color "0C")}}
    [:img {:src (str "/images/products/" img ".png") :height "auto" :width "100%"}]
    [:div.card__content
      [:h4.card__title title]
      [:div.card__description
        [:p description]]
      [:a {:href url :target "_blank" :style {:background-color color}} "View"]]])

(defn member [img title name description social]
  [:div.card
    [:img {:src (str "/images/members/" img ".jpg") :width "100px" :height "100px"}]
    [:div.card__content
      [:h5.card__title name]
      [:h6 title]
      [:div.card__description.card__description--smaller
        (for [p description]
          [:p p])]]
    [:div.card__social
      (for [platform social]
        [social-icon (first platform) (second platform) "20px"])]])
      
(defn app []
  (reagent/create-class
   {:component-did-mount (fn [this] (mainSwiper_breakpointChecker) (targetsSwiper_breakpointChecker))
    :reagent-render
    (fn []
      [:main#mainSwiper.swiper-container
        [:div.swiper-wrapper
          [:section#hero.swiper-slide
            [:div.container
              [:h2 "ZGEN"
                [:span "KIBERNETIKA"]]
              [:h1 "We build an automated future, collectively governed by the generation Z."]]]

          [:section#targets.background--grey.swiper-slide {:data-hash "targets"}
            [:div.container
              [section-title "Targets"]
              [:div#targetsSwiper.swiper-container
                [:div.swiper-wrapper
                  [division "ai" "SOFTWARE EVERYWHERE"
                    ["We automate work with a wide range of technics."
                      "From genetic algorithms to multi-layer neural networks: We build our custom solutions to every problem."
                      "Our team has experts in low-level programming & language design."]]

                  [division "ether" "DIGITAL ASSET MANAGEMENT"
                    ["Redefining value is a massive goal we followed over the past decade."
                      "With +7 years of investment experiences in online game assets,
                       domain addresses and cryptocurrencies,
                       our portfolio is one of the most unique in Hungary."]]

                  [division "webdev" "WEB BUILDING"
                    ["We have a long professional history in web-development and cloud computing."
                      "+100 web-applications and onepagers serve our clients and the ZGEN ecosystem."
                      "From 2017 we have built a custom application creator platform and cloud infrastructure."]]

                  [division "esport" "ESPORT EVENTS"
                    ["We believe online gaming is a new form of connection between friends."
                      "Esport is not only for the top players: our community is forged through gaming, the prize is only makes the cherry on top of the cake."
                      "Meet you at our next League!"]]

                  [division "education" "EDUCATION & MENTORING"
                    ["We organize exclusive programming courses for free on a weekly basis."
                      "One of our main goals with ZGEN is to create a platform where we fund projects of talented guild members and help them bootstrap their ventures."]]]
                [:div.swiper-pagination]]]]

          [:section#partners.swiper-slide {:data-hash "partners"}
            [:div.container
              [section-title "Partners"]
              [:div.partners__wrapper
                [partner "harmony" "harmony.one" "linear-gradient(to right, rgb(0, 173, 232), rgb(102, 248, 190))"
                         "Ecosystem building for the pioneer blockchain project of the future economy."]
                [partner "incognito" "incognito.org" "black"
                         "Business development in the most active blockchain privacy movement."]
                [partner "mta-taki" "mta-taki.hu" "#006004"
                         "IoT development for the center of agricultural research in Hungary"]
                [partner "dummy" "COMING SOON..." "#b2b2b280" ""]]]]                        
                

          [:section#products.swiper-slide {:data-hash "products"}
            [:div.container
              [section-title "Products"]
              [:div.products__wrapper
                [product "sulibot" "Sulibot platform" "#93240A"
                         "Sulibot is an innovative platform aimed to improve student life at high schools.
                          It consists of a Messenger chatbot and an admin webapp.
                          It's featured on several mainstream news sites and has been awarded by the Hungarian Innovation Association."
                         "https://sulibot.hu"]
                [:div.product.product--comingSoon
                  [:div.card__content
                    [:h3.card__title "Coming soon..."]]]]]]

          [:section#members.background--grey.swiper-slide {:data-hash "members"}
            [:div.container
              [section-title "Members"]
              [:div.members__wrapper
                [member "marcell" "Backend" "Marcell Lakos"
                  ["Marcell is a real maker. When he is not playing with electronics, he is developing a web-application backend."]                  
                  [["github" "https://github.com/marclllaks"]]]
                
                [member "domos" "UI/UX" "Domokos Vali"
                  ["Domos is obsessed with designing and creating user-first applications and experiences.
                    His precision is an important ingredient of our products."]
                  [["linkedin" "https://www.linkedin.com/in/domokosvali/"]
                   ["github" "https://github.com/validd"]
                   ["telegram" "https://t.me/Flind"]]]

                [member "samu" "Relations" "Samuel Kallo"
                  ["As an organizer of MCC Debate, Samuel knows a lot about connecting with people.
                    Also, he has been writing for prominent hungarian newspapers since his early years in university."]
                  [["linkedin" "https://www.linkedin.com/in/s%C3%A1muel-k%C3%A1ll%C3%B3-975428152/"]]]              

                [member "berci" "Backend" "Bernat Barnabas Zawiasa"
                  ["Bernát is an engineer guy, who thinks precise and qualitative job is the only job.
                    He designes machines with software behind them."]]

                [member "bruno" "Fullstack" "Bruno Marton Zawiasa"
                  ["Bruno is the all seeing eye of ZGEN and its associates, his natural leader abilities
                    and consistency make him a perfect Chief Operating Officer."]                  
                  [["linkedin" "https://www.linkedin.com/in/bruno-z-411656141/"]
                   ["github" "https://github.com/Brunya"]
                   ["telegram" "https://t.me/zawiasabruno"]]]

                [member "aron" "Strategy" "Robert Aron Zawiasa"
                  ["Robert made his way into the investment world as an early adopter of cryptocurrencies.
                    He is responsible for company strategy as the Chief Investment Officer."]
                  [["linkedin" "https://www.linkedin.com/in/zawiasa/"]
                   ["github" "https://github.com/liszper"]
                   ["twitter" "https://twitter.com/aaronpowered"]
                   ["telegram" "https://t.me/Zawiasa"]]]]]
            [:div#footer
              [:div.container
                [:div.footer__brand
                  [:h3 "ZGEN KIBERNETIKA"]
                  [:span "© 2020"]]
                [:div.footer__contact
                  [:a {:href "mailto:contact@zgen.hu" :target "_BLANK"} "contact@zgen.hu"]
                  [:div.footer__social
                    [social-icon "facebook" "https://facebook.com/zgenkibernetika" "25px"]
                    [social-icon "linkedin" "https://linkedin.com/company/zgen-kibernetika/" "25px"]
                    [social-icon "twitter" "https://twitter.com/KibernetikaZ" "25px"]
                    [social-icon "github" "https://github.com/zgendao" "25px"]
                    [social-icon "telegram" "https://t.me/zegenguild" "25px"]]]]]]]
        [:div#mainPagination.swiper-pagination]])}))
