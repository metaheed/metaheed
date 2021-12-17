;; Copyright (c) Abdullah Mamun, Feb 2020. All rights reserved.  The use
;; and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this
;; distribution.  By using this software in any fashion, you are
;; agreeing to be bound by the terms of this license.  You must not
;; remove this notice, or any other, from this software.

(ns ^{:author "Abdullah Mamun"
      :doc    ""}
  com.metaheed.frontend.comp.view
  (:require
    [cljs.reader :as edn]
    [cljs.pprint :as p]
    [reagent.dom :as rdom]
    [reagent.core :as r :refer [atom]]
    [re-frame.core :as re-frame]
    [ajax.core :as a]
    [re-frame.db :as db]
    [com.metaheed.frontend.comp.events :as events]
    [com.metaheed.frontend.comp.subs :as subs]
    [com.metaheed.frontend.copyright :as cr]
    ;[io.metarx.kolle.http.frontend.subs :as subs]
    ["react-google-login" :refer [GoogleLogin]]
    ["@mui/material" :as mui]
    ["@mui/icons-material" :as mui-icons])
  (:import (goog.i18n DateTimeSymbols_en_US)))


(defn agreement-panel []
      [:span
       [:> mui/Checkbox {:defaultChecked true
                         :color          "secondary"}]
       [:label "By Sign in, you agree to the "]
       [:> mui/Link {:href   "agreement.html"
                     :target "_blank"}
        "Terms of Service."]])


(defn login-view-impl [{:keys [classes] :as props}]
      [:<>
       [:> mui/AppBar
        ;{:style {:height 60}}
        [:> mui/Toolbar {:disable-gutters true}
         [:> mui/IconButton
          {:edge     "start"
           :color    "inherit"
           :on-click (fn [e] (.preventDefault e))}
          [:> mui-icons/Menu]]

         [:> mui/Typography
          {:variant   "h6"
           :component "div"}
          "Metaheed"]]]

       [:> mui/Toolbar]
       [:> mui/Grid {:container       true
                     ;:direction       "column"
                     :justify-content "center"
                     :spacing         1}

        [:> mui/Grid {:item true :xs 12}
         ;[login-ui/login-panel]
         [:> mui/Box {:style {:height 100}}
          [:> mui/Paper {:style     {:height           "100%"
                                     :width            "100%"
                                     :background-color "#D3D3D3"}
                         :elevation 0
                         }]]]

        [:> mui/Grid {:item true :xs 12}
         [:> mui/Grid {:container       true
                       :justify-content "center"
                       :spacing         1}

          [:> mui/Grid {:item true :xs 5}
           [:> mui/Typography {:variant "h6" :component "h2"} "Kolle - Zero code based metadata driven data pipeline automation"]
           [:> mui/Link {:href   "https://kolle.metaheed.com"
                         :target "_blank"
                         }
            "Try Kolle"]]
          #_[:> mui/Grid {:item true :xs 12}
             [:> mui/Typography {:variant "h6" :component "h2"} "Metadata driven data quality profiling"]]
          [:> mui/Grid {:item true}]]]
        [:> mui/Grid {:item true :xs 3}
         [cr/copyright-ui]]]])


(defn login-main [with-custom-styles custom-theme]
      [:<>
       [:> mui/CssBaseline]
       ;; mui-pickers-utils-provider provides date handling utils to date and time pickers.
       ;; cljs-time-utils is an utility package that allows you to use cljs-time / goog.date date objects.
       [:> mui/ThemeProvider
        {:theme custom-theme}
        [:> mui/Grid
         {:container       true
          :direction       "row"
          :justify-content "center"}
         [:> mui/Grid
          {:item true
           :xs   12}
          [:> (with-custom-styles (r/reactify-component login-view-impl))]]]]])



