(ns padder.pads-test
  (:require [clojure.test :refer :all]
            [padder.pads :refer :all]))

(deftest test-pads
  (testing "makepad"
    (is (= "@@" (#'padder.pads/makepad 2 \@)))
    (is (= "" (#'padder.pads/makepad 0 \@)))
    ;; "\ " is a literal space char, intentional
    (is (= " " (#'padder.pads/makepad 1 \ )))
    (is (= " " (#'padder.pads/makepad 1 " "))))
  (testing "leftpad"
    (is (= "@@test" (leftpad "test" 2 \@))))
  (testing "rightpad"
    (is (= "test@@" (rightpad "test" 2 \@))))
  (testing "centerpad"
    (is (= "@@test@@" (centerpad "test" 2 \@)))))
