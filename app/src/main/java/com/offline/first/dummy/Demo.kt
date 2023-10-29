package com.offline.first.dummy

object Demo {

    fun <T : InClass> functionIn(param: T) {

    }

    fun <T : InClass> function(param: T) {

    }

    fun sum(list: List<Number>): Double {
        var sum = 0.0
        for (n in list) {
            sum += n.toDouble()
        }
        return sum
    }
    fun demo(){
        Demo.functionIn(InClass())
        Demo.functionIn(InClassE())

        Demo.sum(arrayListOf(1,2,3))


        Dummy.sum(arrayListOf(1,2,3))


        Demo.check(InClassE())
        Demo.checkE(InClassE())
    }



    fun <T : InClass> check(param: T) {

    }

    fun <T : InClassE> checkE(param: T) {

    }
}

open class InClass{

}
class InClassE : InClass()