(ns padder.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [padder.handler :refer :all]))

(deftest test-app
  (testing "main route"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (= (:body response) "Hello World"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))

  (testing "leftpad route"
    (let [response (app (mock/request
                         :get "/leftpad"
                         {:string "test" :size 2 :pad "@"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "@@test"))))

  (testing "rightpad route"
    (let [response (app (mock/request
                         :get "/rightpad"
                         {:string "test" :size 2 :pad "@"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "test@@"))))

  (testing "center route"
    (let [response (app (mock/request
                         :get "/centerpad"
                         {:string "test" :size 2 :pad "@"}))]
      (is (= (:status response) 200))
      (is (= (:body response) "@@test@@")))))
