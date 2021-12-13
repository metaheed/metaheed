(ns com.metaheed.frontend.copyright
  (:require ["@mui/material" :as mui]
            ["@mui/icons-material" :as mui-icons]))

(defn copyright-ui []
      [:> mui/Grid {:container true   :justify-content "center"}
       [:> mui/Grid {:item true :xs 10}
        [:> mui/Link
         {:href      "#"
          :underline "hover"
          :on-click  (fn [e] (.preventDefault e))}
         "Copyright @2022 Metaheed "]
        ]
       #_[:> mui/Grid {:item true :xs 10}
        [:> mui/Link
         {:href      "#"
          :underline "hover"
          :on-click  (fn [e] (.preventDefault e))}
         "Version beta @v0.0.1"]
        ]
       ]
      )