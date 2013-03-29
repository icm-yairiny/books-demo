(defproject books "0.1.0-SNAPSHOT"
  :description "Ember JS and Clojure Book Catalogue Tutorial"
  :url "http://icm-consulting.com.au"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.5"]
                 [postgresql "9.1-901.jdbc4"]
                 [korma "0.3.0-RC4"]
                 [ring/ring-json "0.2.0"]]
  :plugins [[lein-ring "0.8.2"]]
  :ring {:handler books.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
