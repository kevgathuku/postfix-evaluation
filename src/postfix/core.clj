(ns postfix.core
  (:require [clojure.string :as string]))


;; Scan the expression left to right
;; Skip values or variables (operands)
;; When an operator is found, apply the operation to the preceding two operands
;; Replace the two operands and operator with the calculated value
;; Continue scanning until only a value remains --the result of the expression

;; Example: 
;; "2 3 4 + * 5 -"
;; '(2 (3 4 +) * 5 -)
;; '((2 7 *) 5 -)
;; '(14 5 -)
;; 9

(defn last-to-first
  "Returns a list where the last element of coll is moved to the first position"
  [coll]
  (cons (last coll) (butlast coll)))


(defn evaluate-postfix-expression
  "Takes a single postfix expression as a string and returns the value
  obtained from evaluating the expression
  e.g. '3 4 +' is evaluated to 1"
  [exp]
  (let [split-exp (string/split exp #" ")]
    (do 
      (println "expression" exp)
      (eval (read-string (str "(" (string/join " " (last-to-first split-exp)) ")"))))))
  

(defn remove-extra-whitespace
  [words]
  (string/join " " (string/split words #"\s+")))


(defn evaluator-regexp
  "Evaluates a postfix notation expression using a regular expression"
  [expression]
  (cond 
    (= (count expression) 1) expression
    (= (count (string/split expression #"\s+")) 3) (evaluate-postfix-expression expression)
    (> (count expression) 3)
    (let [expression (remove-extra-whitespace expression) regexp #"(?:\d+\s*){2}[\+\-\\\*]" match (re-find regexp expression)]
      (do
        (println "exp" expression)
        (println "match" match)
        (evaluator-regexp (string/replace expression regexp (str (evaluate-postfix-expression match))))))))


(defn evaluator-stack
  ;; TODO: Use a stack
  [expression])

