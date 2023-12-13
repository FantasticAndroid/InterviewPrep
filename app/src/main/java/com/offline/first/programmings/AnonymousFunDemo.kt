package com.offline.first.programmings

object AnonymousFunDemo {

    /*Kotlin functions are considered “First Class Citizen” which means they can be assigned to variables,
 passed as parameters to other functions, or returned as function values.*/
    fun anonymousFunExample() {
        //Syntax of Anonymous Function
        /*val myVariableName: (FirstDataType,SecondDataType) -> ReturnType =
            fun(firstParameter,secondParameter): ReturnType { MethodBody }*/

        //Example of Anonymous Function:
        val myVariable: (String, String) -> String = fun(a, b): String {
            return "$a $b"
        }

        // Shorter Syntax Of Anonymous Function
        /*val myVariableName = fun(FirstDataType,SecondDataType) : ReturnType { MethodBody }*/

        val myVariableShort = fun(a: String, b: String): String { return "$a + $b" }

        // When the method body contains just one statement,
        // the return keyword and braces can be omitted.
        val myVariableShorter = fun(a: String, b: String): String = "$a + $b"

        // Let's explore various anonymous function formats,
        // depending on the parameters and return type.

        // 1- With Parameters and No Return Value:
        val myVariable1 = fun(a: String, b: String): Unit {
            println("$a $b")
        }

        // 2- With Parameters and Return Value:
        val myVariable2 = fun(a: String, b: String): String {
            return "$a $b"
        }

        // 3- No Parameters and No Return Value:
        val myVariable3 = fun(): Unit {
            println("No Parameters and No Return Value:")
        }

        // 4- No Parameters and Return Value:
        val myVariable4 = fun(): String {
            return "Hi!"
        }
    }
}