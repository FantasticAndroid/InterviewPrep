package com.offline.first.programmings

object LambdaFunDemo {

    fun lambdaFunExample() {
        // It take two params and return String
        // VariableName : FunctionType = { parameters -> method body }
        val lambdaFun1: (Int, String) -> String = { a: Int, b: String -> b.plus(a) }
        val lambdaFun2 = { a: Int, b: String -> b.plus(a) }
        val lambdaFun3: (Int, String) -> String = { a, b -> b.plus(a) }

        val lambdaFun4 = {}
        val lambdaFun5: (a: String) -> Unit = { a -> }
        val lambdaFun6: () -> String = { "" }


        //or
        //There are four function types, varying based on parameters and return types.

        // 1-With Parameters and No Return Value:
        val myVariable: (Int, String) -> Unit = { a: Int, b: String -> println("$a + $b") }

        // 2-With Parameters and Return Value:
        val myVariable2: (Int, String) -> String = { a: Int, b: String -> "$a + $b" }

        // 3-No Parameters and No Return Value:
        val myVariable3: () -> Unit = { println("No Parameters and No Return Value") }

        // 4-No Parameters and Return Value:
        val myVariable4: () -> String = { "Return String" }

        // 5-A variable isn't always necessary, as lambda expressions can be used directly.
        println({ a: String, b: String -> "$a $b" }("Hüseyin", "Özkoç"))
    }
}