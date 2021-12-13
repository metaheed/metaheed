;; Copyright (c) Abdullah Mamun, Feb 2020. All rights reserved.  The use
;; and distribution terms for this software are covered by the Eclipse
;; Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;; which can be found in the file epl-v10.html at the root of this
;; distribution.  By using this software in any fashion, you are
;; agreeing to be bound by the terms of this license.  You must not
;; remove this notice, or any other, from this software.

(ns ^{:author "Abdullah Mamun"
      :doc    ""}
  io.metarx.kolle.http.frontend.comp.events
  (:require [re-frame.core :as re-frame]
            [clojure.string :as str]
            [ajax.core :as a]
            [re-frame.db :as db]
            [io.metarx.kolle.http.frontend.db :as api]
            [reagent.core :as r :refer [atom]]))


