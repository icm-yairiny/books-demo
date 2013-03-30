(ns books.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.util.response :as resp]
            [ring.middleware.json :as json]
            [books.db :as db]))

(defn- to-int
  "converts a string to an integer"
  [s]
  (Integer/valueOf s))

(def ^:private conversions
  "a map of parameter name and converter"
  {:author_id to-int
   :book_id to-int})

(defn- convert-params
  "converts specific parameters to their proper types"
  [params]
  (reduce (fn [m [k v]]
            (if-let [converter-fn (conversions k)]
              (assoc m k (converter-fn v))
              m))
          params params))

(defn- convert-params-handler
  "a compojure handler to convert incoming parameters"
  [app]
  (fn [{params :params :as req}]
    (app (assoc req :params (convert-params params)))))

(defroutes data-routes
  (GET "/authors/:id" [id]
       (resp/response
        {:author (db/get-author (to-int id))}))
  (GET "/authors" {params :params}
       (resp/response
        {:authors (db/find-authors params)}))
  (GET "/books/:id" [id]
       (resp/response
        {:book (db/get-book (to-int id))}))
  (GET "/books" {params :params}
       (resp/response
        {:books (db/find-books params)})))

(defroutes app-routes
  (GET "/" [] (resp/redirect "/index.html"))
  (route/resources "/")

  (context "/data" []
           (-> data-routes convert-params-handler json/wrap-json-response))

  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
