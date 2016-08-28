(ns project.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljsjs.material-ui]
            [cljs-react-material-ui.core :as ui]
            [cljs-react-material-ui.reagent :as rui]
            [cljs-react-material-ui.icons :as ic]))

(enable-console-print!)

(println "This text is printed from src/project/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn home-page []
  [rui/mui-theme-provider
   {:mui-theme (ui/get-mui-theme
                {:palette {:text-color (ui/color :green600)}})}
   [:div
    [rui/app-bar {:title              "Title"
                  :icon-element-right (ui/icon-button
                                       (ic/action-account-balance-wallet))}]
    [rui/paper
     [:div "Hello"]
     [rui/mui-theme-provider
      {:mui-theme (ui/get-mui-theme {:palette {:text-color (ui/color :blue200)}})}
      [rui/raised-button {:label "Blue button"}]]
     (ic/action-home {:color (ui/color :grey600)})
     [rui/raised-button {:label        "Click me"
                         :icon         (ic/social-group)
                         :on-touch-tap #(println "clicked")}]]]])

(defn hello-world []
  [:h1 (:text @app-state)])

(reagent/render-component [home-page]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
