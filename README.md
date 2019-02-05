# postfix

A Clojure library designed to evaluate postfix expressions. 

An example of a postfix expression is `1 2 3 + 4 5 * * +`  
The infix notation version of this expression is `( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) `

## Usage

To use the regexp-based evaluator, start a `repl` and run:
```
(evaluator-regexp "expression as a string")
```

## License

Copyright © 2019 Kevin Ndung'u Gathuku

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
