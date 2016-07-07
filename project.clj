(defproject com.example/figwheel-webjars "0.1.0-SNAPSHOT"
  :dependencies [[com.cemerick/piggieback "0.2.1"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [figwheel-sidecar "0.5.4-5"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.89"
                  :scope "provided"]
                 [org.webjars.bower/foundation-sites "6.2.1"]]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-5"]]

  :source-paths ["src/clj"]

  :cljsbuild {:builds
              [{:id "dev"
                :figwheel true
                :source-paths ["src/cljs"]
                :compiler {:main "figwheel-webjars.core"
                           :output-to "resources/public/js/app.js"
                           :output-dir "resources/public/js/out"
                           :foreign-libs [{:file "META-INF/resources/webjars/foundation-sites/6.2.1/dist/foundation.min.js"
                                           :provides ["foundation"]}]
                           :asset-path "/js/out"
                           :source-map true
                           :source-map-timestamp true
                           :optimizations :none
                           :pretty-print true}}]}

  :figwheel {:http-server-root "public"
             :server-port 3449
             :nrepl-port 7002
             :server-ip "0.0.0.0"
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["resources/public/css"]})
