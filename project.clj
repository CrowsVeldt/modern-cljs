(defproject modern-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.1.2"

  ;; clojure source code path
  :source-paths ["src/clj"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1847"]
                 [compojure "1.1.5"]
                 [domina "1.0.2-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "0.3.3"]
            [lein-ring "0.8.7"]]

  ;; ring tasks configuration
  :ring {:handler modern-cljs.core/handler}

  ;; cljsbuild tasks configuration
  :cljsbuild {:builds
              {:dev
               {;; clojurescript source code path
                :source-paths ["src/brepl" "src/cljs"]

                ;; Google Closure Compiler options
                :compiler {;; the name of emitted JS script file
                           :output-to "resources/public/js/modern_dbg.js"

                           ;; minimum optimization
                           :optimizations :whitespace
                           ;; prettyfying emitted JS
                           :pretty-print true}}
               :pre-prod
               {;; same path as above
                :source-paths ["src/brepl" "src/cljs"]

                :compiler {;; different JS output name
                           :output-to "resources/public/js/modern_pre.js"

                           ;; simple optimization
                           :optimizations :simple

                           ;; no need prettification
                           :pretty-print false}}
               :prod
               {;; same path as above
                :source-paths ["src/cljs"]

                :compiler {;; different JS output name
                           :output-to "resources/public/js/modern.js"

                           ;; advanced optimization
                           :optimizations :advanced

                           ;; no need prettification
                           :pretty-print false}}
               }})
