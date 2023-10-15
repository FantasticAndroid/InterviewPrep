package com.offline.first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.offline.first.problemsolving.ArrayIntersectionImpl
import com.offline.first.problemsolving.DecimalToConvertor
import com.offline.first.problemsolving.PalindromeImpl
import com.offline.first.problemsolving.SeparateNoInArray
import com.offline.first.problemsolving.StringReverseImpl3
import com.offline.first.ui.theme.OfflineFirstDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OfflineFirstDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    printText("")
                    applyDemos()
                }
            }
        }
    }
}

fun lambdaFunExample() {
    // It take two params and return String
    // VariableName : FunctionType = { parameters -> method body }
    val lambdaFun1: (Int, String) -> String = { a: Int, b: String -> b.plus(a) }
    val lambdaFun2 = { a: Int, b: String -> b.plus(a) }
    val lambdaFun3: (Int, String) -> String = { a, b -> b.plus(a) }

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

/*Kotlin functions are considered “First Class Citizen” which means they can be assigned to variables, passed as parameters to other functions, or returned as function values.*/
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OfflineFirstDemoTheme {
        Greeting("Android")
    }
}

@Composable
private fun applyDemos() {
    //BubbleSort.applyBubbleSortDemo()
    //InsertionSort.applyInsertionSortDemo()
    //SelectionSort.applySelectionSortDemo()
    //QuickSort.applyQuickSortDemo()
    //MergeSort.applyMergeSortDemo()
    //CountSort.applyCountSortDemo()
    //GraphTraversal.applyGraphTraversal()
    //CircularQueueOpt.applyCircularQueue()
    //BinarySearch.applyBinarySearch()
    //DoublyLinkedListOpt.applyDoublyLinkedList( )

    //BinarySearchTreeOpt.applyBinarySearchTree()

    //OperatorsDemo.applyConcat()
    //OperatorsDemo.applyMerge()
    //OperatorsDemo.applySwitchMap()
    //OperatorsDemo.applyCombineLatest()
    //ObservableDemo.applyObservableDemo6()

    /*SubjectDemo.applyPublishSubjectDemo()
    SubjectDemo.applyBehaviorSubjectDemo()
    SubjectDemo.applyReplaySubjectDemo()
    SubjectDemo.applyAsyncSubjectDemo()*/

    //CompositeImpl.applyCompositeImpl()

    //StringReverseImpl1.reverseString("This")
    /*val textToPrint = PyramidImpl1.showPyramid(10)
    printText(textToPrint = textToPrint)*/

    //DuplicateCharsInString.findDuplicateCharsInString("Better Butter")
    //ArraysAreEqual.findArraysAreEqual(arrayOf(5,4,3,2,1), arrayOf(5,4,3,2,1))
    //ArraysAreEqual.findArraysAreEqual2(arrayOf(1,2,3,4,5), arrayOf(5,4,3,2,1))
    /*ArmstrongImpl.findArmstrongNo(153)
    ArmstrongImpl.findArmstrongNo(54748)
    ArmstrongImpl.findArmstrongNo(407)
    ArmstrongImpl.findArmstrongNo(1234)*/
    //AnagramImpl.findAnagram("Mother In Law", "Hitler Woman")
    //AnagramImpl.findAnagram("Mother In Law1", "Hitler Woman2")
    //SumOfDigitsImpl.findSumOfDigits(923045)
    //FindNumberImpl.findGivenNumberImpl(145)
    //FindNumberImpl.findPairInArray(arrayOf(4, 1, 3, 3, 5, 2, 0, 6, 5, 4))
    /*FindNumberImpl.findSubArray(arrayOf(4, 1, 3, 3, 5, 2, 0, 6, 5, 4))
    FindNumberImpl.findSubArray(arrayOf(1, 3, 3, 5, 2, 0, 6, 5, 4))
    FindNumberImpl.findSubArray(arrayOf(1, 3, 3, 5, 2, 0, 6, 5))
    FindNumberImpl.findSubArray(arrayOf(1, 3, 3, 5, 2, 0, 6, 5, 2 , 7, 5))*/
    //FindNumberImpl.removeDuplicate(arrayOf(1, 3, 3, 5, 2, 0, 6, 5, 2, 0, 7, 5))
    //FindNumberImpl.removeDuplicate(arrayOf(3,2,3,3 ))
    //FindNumberImpl.findStringIsRotated("JavaSpringKotlin", "KotlinJavaSpring")
    //FindNumberImpl.findStringIsRotated("JavaSpringKotlin", "KotlinSpringJava")
    /*ArrayIntersectionImpl.findCommonElementsIn(
        arrayOf(11, 15, 17, 36, 89, 55),
        arrayOf(10, 13, 17, 36, 99, 155, 15)
    )*/
    //StringReverseImpl3.reverseWordsInString("This is Java and Kotlin world")
    //SeparateNoInArray.separateNoFromArray(arrayOf(1,3,5,8,0,6,9,3,5,0,8,9,7,8),8)
    /*DecimalToConvertor.decimalToConvertor(50, 2)
    DecimalToConvertor.decimalToConvertor(1000, 8)
    DecimalToConvertor.decimalToConvertor(2000, 16)*/

    PalindromeImpl.findPalindrome(12321)
    PalindromeImpl.findPalindrome(12344321)
    PalindromeImpl.findPalindrome(12343321)
    PalindromeImpl.findPalindrome(12334321)
}

@Composable
fun printText(textToPrint: String) {
    Text(
        textAlign = TextAlign.Center,
        text = textToPrint
    )
}