(ns mars-rover.core
    (:require [mars-rover.seq :refer :all])
    (:require [mars-rover.world :refer :all]))

(defn rotate [object command]
    (let [compass (if (= "R" command) compass (reverse compass))]
     (assoc object :direction (nth (cycle compass) (+ 1 (.indexOf compass (:direction object)))))))

(defn go [object command]
    (let [axis (get-in coordinate-system [(:direction object) :axis])
          modifier (get-in coordinate-system [(:direction object) :modifier])]
     (assoc object axis (modifier (axis object) (if (= "F" command) 1 -1)))))

(defn move-or-rotate [object command]
     (if (in? ["F" "B"] command)
      (go object command)
      (rotate object command)))

(defn move
  "Send a set of movement commands to an object"
  [object commands]
  (if (seq commands)
   (reduce move-or-rotate object commands)
   object))
