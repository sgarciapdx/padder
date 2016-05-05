(ns padder.pads-test
  (:require [clojure.test :refer :all]
            [padder.pads :refer :all]))

(deftest test-pads
  (testing "leftpad"
    (is (= "@@test" (leftpad "test" 2 \@))))
  (testing "rightpad"
    (is (= "test@@" (rightpad "test" 2 \@))))
  (testing "centerpad"
    (is (= "@@test@@" (centerpad "test" 2 \@)))))
