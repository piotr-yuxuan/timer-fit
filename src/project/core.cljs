(ns project.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljsjs.material-ui]
            [cljs-react-material-ui.core :as ui]
            [cljs-react-material-ui.reagent :as rui]
            [cljs-react-material-ui.icons :as ic]))

(enable-console-print!)

(println "This text is printed from src/project/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:exercice-1 :todo
                          :exercice-2 :todo
                          :exercice-3 :todo
                          :exercice-4 :todo}))

(defn- toggle-state
  [state]
  (case state
    :done :todo
    :todo :done))

(defn home-page []
  [rui/mui-theme-provider
   {:mui-theme (ui/get-mui-theme
                {:palette {:text-color (ui/color :green600)}})}
   [:div
    [rui/list
     [rui/list-item {:primary-text "This is an exercise 1"
                     :disabled (= :done (:exercice-1 @app-state))
                     :on-click #(swap! app-state assoc :exercice-1 (toggle-state (:exercice-1 @app-state)))}]
     [rui/list-item {:primary-text "This is an exercise 2"
                     :disabled (= :done (:exercice-2 @app-state))
                     :on-click #(swap! app-state assoc :exercice-2 (toggle-state (:exercice-2 @app-state)))}]
     [rui/list-item {:primary-text "This is an exercise 3"
                     :disabled (= :done (:exercice-3 @app-state))
                     :on-click #(swap! app-state assoc :exercice-3 (toggle-state (:exercice-3 @app-state)))}]
     [rui/list-item {:primary-text "This is an exercise 4"
                     :disabled (= :done (:exercice-4 @app-state))
                     :on-click #(swap! app-state assoc :exercice-4 (toggle-state (:exercice-4 @app-state)))}]]]])

(reagent/render-component [home-page]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
