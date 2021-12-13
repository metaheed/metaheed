;; Copyright (c) Abdullah Mamun, Feb 2020. All rights reserved.  The use
;; and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this
;; distribution.  By using this software in any fashion, you are
;; agreeing to be bound by the terms of this license.  You must not
;; remove this notice, or any other, from this software.

(ns ^{:author "Abdullah Mamun"
      :doc    ""}
  io.metarx.kolle.http.frontend.app
  (:require
    [cljs.reader :as edn]
    [cljs.pprint :as p]
    [io.metarx.kolle.http.frontend.db]
    [io.metarx.kolle.http.frontend.comp.view :as lview]
    ["@mui/material" :as mui]
    ["@mui/icons-material" :as mui-icons]
    ["@mui/styles" :refer [withStyles]]
    ["@mui/material/styles" :refer [createTheme Theme ThemeProvider] :as st]
    ["@mui/material/colors" :as mui-colors]
    [reagent.dom :as rdom]
    [reagent.core :as r :refer [atom]]
    [re-frame.core :as re-frame]
    [day8.re-frame.async-flow-fx :as async-flow-fx]
    [goog.object :as gobj]))





(def custom-theme
  (createTheme
    #js {:component #js {:listItem #js {:defaultProps #js {:dense false}

                                        }}
         :palette1  #js {:primary #js {:main (gobj/get
                                               ; (.-blue ^js/Mui.Colors mui-colors)
                                               (.-indigo ^js/Mui.Colors mui-colors)
                                               500)}}}))

(defn custom-styles [^st/Theme theme]
      #js {
           ;:button       #js {:margin (.spacing theme 1)}
           :textField    #js {:width 200
                              ;:marginLeft  (.spacing theme 1)
                              ;:marginRight (.spacing theme 1)
                              }
           :rightToolBar #js {:marginLeft  "auto"
                              :marginRight -12}})

(def with-custom-styles (withStyles custom-styles))

(defn ^{:after-load true, :dev/after-load true} mount []
      (let [app-div (js/document.getElementById "app")]
           (rdom/render [lview/login-main with-custom-styles custom-theme] app-div)))


(defn ^:export init []
      (mount))