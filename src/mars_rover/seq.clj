(ns mars-rover.seq)

(defn in?
  "true if seq contains elm"
  [seq elm]
  (some #(= elm %) seq))
