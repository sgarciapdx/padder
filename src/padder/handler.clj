(ns padder.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [compojure.coercions :refer :all]
            [padder.pads :refer :all]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (GET "/leftpad" [string size :<< as-int pad] (leftpad string size pad))
  (GET "/rightpad" [string size :<< as-int pad] (rightpad string size pad))
  (GET "/centerpad" [string size :<< as-int pad] (centerpad string size pad))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
