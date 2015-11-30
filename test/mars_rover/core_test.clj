(ns mars-rover.core-test
  (:use midje.sweet)
  (:require [mars-rover.core :refer :all]))

(fact "Rover should not move when no commands given"
 (move { :x 0 :y 0 :direction "N"} []) => { :x 0 :y 0 :direction "N"}
 (move { :x 1 :y 0 :direction "N"} []) => { :x 1 :y 0 :direction "N"}
 (move { :x 1 :y 1 :direction "N"}[]) => { :x 1 :y 1 :direction "N"}
 (move { :x 1 :y 1 :direction "S"}[]) => { :x 1 :y 1 :direction "S"})

(fact "Rover should move forward"
  (move { :x 0 :y 0 :direction "N"} ["F"]) => {:x 0 :y 1 :direction "N"}
  (move { :x 0 :y 1 :direction "N"} ["F"]) => {:x 0 :y 2 :direction "N"}
  (move { :x 0 :y 0 :direction "S"} ["F"]) => { :x 0 :y -1 :direction "S"}
  (move { :x 0 :y 0 :direction "E"} ["F"]) => { :x 1 :y 0 :direction "E"}
  (move { :x 0 :y 0 :direction "W"} ["F"]) => { :x -1 :y 0 :direction "W"})

(fact "Rover should rotate right"
    (move { :x 0 :y 0 :direction "N"} ["R"]) => { :x 0 :y 0 :direction "E"}
    (move { :x 0 :y 0 :direction "S"} ["R"]) => { :x 0 :y 0 :direction "W"}
    (move { :x 0 :y 0 :direction "E"} ["R"]) => { :x 0 :y 0 :direction "S"}
    (move { :x 0 :y 0 :direction "W"} ["R"]) => { :x 0 :y 0 :direction "N"})

(fact "Rover should rotate left"
    (move { :x 0 :y 0 :direction "N"} ["L"]) => { :x 0 :y 0 :direction "W"}
    (move { :x 0 :y 0 :direction "S"} ["L"]) => { :x 0 :y 0 :direction "E"}
    (move { :x 0 :y 0 :direction "E"} ["L"]) => { :x 0 :y 0 :direction "N"}
    (move { :x 0 :y 0 :direction "W"} ["L"]) => { :x 0 :y 0 :direction "S"})

(fact "Rover should move backwards"
    (move { :x 0 :y 0 :direction "N"} ["B"]) => { :x 0 :y -1 :direction "N"}
    (move { :x 0 :y 0 :direction "E"} ["B"]) => { :x -1 :y 0 :direction "E"}
    (move { :x 0 :y 0 :direction "W"} ["B"]) => { :x 1 :y 0 :direction "W"}
    (move { :x 0 :y 0 :direction "S"} ["B"]) => { :x 0 :y 1 :direction "S"})

(fact "Rover should handle multiple commands at once"
    (move { :x 0 :y 0 :direction "N" } ["F" "R" "B" "L" "F"]) => { :x -1 :y 2 :direction "N"})
