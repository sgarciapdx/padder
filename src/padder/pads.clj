(ns padder.pads)

(defn- makepad [size pad]
  (apply str (repeat size pad)))

(defn leftpad [string size pad]
  (str (makepad size pad) string))

(defn rightpad [string size pad]
  (str string (makepad size pad)))

(defn centerpad [string size pad]
  (let [x (makepad size pad)]
    (str x string x)))
