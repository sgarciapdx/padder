(ns padder.pads)

(defn leftpad [string size pad]
  (str (apply str (repeat size pad)) string))

(defn rightpad [string size pad]
  (str string (apply str (repeat size pad))))

(defn centerpad [string size pad]
  (leftpad (rightpad string size pad) size pad))
