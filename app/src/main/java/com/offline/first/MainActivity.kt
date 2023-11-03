package com.offline.first

import android.os.Bundle
import android.util.Log
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
import androidx.lifecycle.lifecycleScope
import com.offline.first.designpatterns.delegates.TAG
import com.offline.first.flow.FlowDemo
import com.offline.first.ui.theme.OfflineFirstDemoTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // To Test LeakCanary only
        // InterviewApp.main = this
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
                    //applyRunBlockingDemo()
                }
            }
        }
        /*startActivity(Intent(this, DelegateActivity::class.java))
        finish()*/
    }

    private fun applyRunBlockingDemo() {
        Log.d(TAG,"applyRunBlockingDemo Before run-blocking")
        lifecycleScope.launch(Dispatchers.IO) {
            Log.d(TAG,"applyRunBlockingDemo just entered into the runBlocking ")
            //delay(5000)

            Log.d(TAG,"applyRunBlockingDemo start of the run-blocking")
            Log.d(TAG,"applyRunBlockingDemo End of the runBlocking")
        }
        Log.d(TAG,"applyRunBlockingDemo after the run blocking")

        /*lifecycleScope.launch(Dispatchers.IO) {
            Log.d(TAG,"applyRunBlockingDemo just entered into the runBlocking ")
            //delay(5000)

            Log.d(TAG,"applyRunBlockingDemo start of the run-blocking")
            Log.d(TAG,"applyRunBlockingDemo End of the runBlocking")
        }

        Log.d(TAG,"applyRunBlockingDemo after the run blocking")*/

        /*********************************/

        /*runBlocking(Dispatchers.IO){
            Log.d(TAG,"applyRunBlockingDemo just entered into the runBlocking ")
            delay(5000)

            Log.d(TAG,"applyRunBlockingDemo start of the run-blocking")
            Log.d(TAG,"applyRunBlockingDemo End of the runBlocking")
        }
        Log.d(TAG,"applyRunBlockingDemo after the run blocking")*/
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

    /*OperatorsDemo.applyConcat()
    OperatorsDemo.applyMerge()*/

    /*OperatorsDemo.applyFlatMap2()
    OperatorsDemo.applySwitchMap2()*/

    //OperatorsDemo.applyFlatMapDelay()
    //OperatorsDemo.applySwitchMapDelay()

    //OperatorsDemo.applySwitchMap()
    //OperatorsDemo.applyCombineLatest()
    //OperatorsDemo.applyCombineLatest2()
    //ObservableDemo.applyObservableDemo6()

    //ReduceOperatorsDemo.applyCountOperator()
    //ReduceOperatorsDemo.applyReduceOperator()

    //TransformationalOperatorDemo.applyScanOperator()
    //TransformationalOperatorDemo.applyBufferOperator()
    //TransformationalOperatorDemo.applySwitchMapDelay()

    //CombiningOperatorsDemo.applySwitchOnNext()

    //SubjectDemo.applyPublishSubjectDemo()
    //SubjectDemo.applyBehaviorSubjectDemo()
    //SubjectDemo.applyReplaySubjectDemo()
    //SubjectDemo.applyAsyncSubjectDemo()

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
    //AnagramImpl.findAnagram2("Mother In Law", "Hitler Woman")

    //FindInNumberOrStringImpl.findSecondLargestInArray(arrayOf(45, 51, 28, 75, 49, 42))
    //FindInNumberOrStringImpl.findSecondLargestInArray(arrayOf(985, 521, 975, 831, 479, 861))

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

    /*PalindromeImpl.findPalindrome(12321)
    PalindromeImpl.findPalindrome(12344321)
    PalindromeImpl.findPalindrome(12343321)
    PalindromeImpl.findPalindrome(12334321)*/

    /*Program.findLength("pwwkkew")
    Program.findLength("pww kkew")
    Program.findLength("pwwkewke")
    Program.findLength("abcdef abcdef fdcbd ")
    Program.findLength("abcdeedcbaa")*/

    //ObserverPatternImpl.applyObserverPattern()

    /*FindInNumberOrStringImpl.findAnyLargestNoFromArray(arrayOf(1,2,3,4,5), 5)
    FindInNumberOrStringImpl.findAnyLargestNoFromArray(arrayOf(5,4,3,2,1), 5)
    FindInNumberOrStringImpl.findAnyLargestNoFromArray(arrayOf(5,4,3,7,6), 3)
    FindInNumberOrStringImpl.findAnyLargestNoFromArray(arrayOf(10,5,50,45,55,4,70,1,0,9), 2)*/

    //FindInNumberOrStringImpl.findLongestSubStringWithoutRepeatingCharacters("GeeksForGeeks")
    //FindInNumberOrStringImpl.findLongestSubStringWithoutRepeatingCharacters("Thisisrepeat")
    //FindInNumberOrStringImpl.findLongestSubStringWithoutRepeatingCharacters("bookanytickettransfer")

    //LeetCode.findBitwiseXORArray(intArrayOf(5,2,0,3,1))
    //LinkListNode.main()

    FlowDemo.flowOfDemo()
    FlowDemo.asFlowDemo()
    FlowDemo.flowDemo()
    FlowDemo.channelFlowDemo()
}

@Composable
fun printText(textToPrint: String) {
    Text(
        textAlign = TextAlign.Center,
        text = textToPrint
    )
}