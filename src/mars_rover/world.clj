(ns mars-rover.world)

(def coordinate-system {"N" { :axis :y :modifier + } "S" { :axis :y :modifier -} "E" { :axis :x :modifier +} "W" { :axis :x :modifier -}})
(def compass ["N" "E" "S" "W"])
