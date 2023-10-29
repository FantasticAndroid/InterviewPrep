package com.offline.first.designpatterns.delegates

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import com.offline.first.R
import kotlin.properties.Delegates

const val TAG = "DelegatesDemo"

/**
 * Delegation is a design pattern that allows you to pass a request to another object,
 * called the delegate. The delegate is responsible for handling the request
 * on behalf of the original object.
 */
class DelegateActivity : AppCompatActivity(), IEventLogger by EventLogger() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delegate)
        registerUIEvent(this)
        logEvent("CustomEventCode", "CustomEventMessage")

        demoDelegates()
    }

    override fun registerUIEvent(owner: LifecycleOwner) {
        TODO("Not yet implemented")
    }

    private fun demoDelegates(){

        DelegatesDemo.apply {
            val lazyValue = lazyDelegate
            val lazyValue2 = lazyDelegate

            Log.d(TAG, "observerDelegate :$observerDelegate")
            Log.d(TAG, "vetoableDelegate :$vetoableDelegate")
            Log.d(TAG, "CHANGE in Delegate")
            observerDelegate = "DemoDelegates"
            //vetoableDelegate will only chaged if new vetoableDelegate contains "Demo".
            vetoableDelegate = "DemeDelegates" // vetoableDelegate will not changed

            vetoableDelegate = "DemoDelegates" // vetoableDelegate will be changed

            Log.d(TAG, "observerDelegate :$observerDelegate")
            Log.d(TAG, "vetoableDelegate :$vetoableDelegate")
        }
    }
}

/**
 * https://www.simplilearn.com/tutorials/kotlin-tutorial/all-need-to-know-about-kotlin-delegation
 */
object DelegatesDemo {

    val lazyDelegate: String by lazy {
        Log.d(TAG, "lazyDelegate")
        this.javaClass.simpleName
    }

    /**
     *  The callback which is called after the change of the property is made.
     *  The value of the property has already been changed when this callback is invoked.
     */
    var observerDelegate: String by Delegates.observable(this.javaClass.simpleName) { property, oldValue, newValue ->
        Log.d(TAG, "observerDelegate oldValue: $oldValue, newValue: $newValue")
    }

    /**
     * If the callback returns true the value of the property is being set to the new value,
     * and if the callback returns false the new value is discarded and the property remains its old value.
     */
    var vetoableDelegate: String by Delegates.vetoable(this.javaClass.simpleName) { property, oldValue, newValue ->
        Log.d(TAG, "vetoableDelegate oldValue: $oldValue, newValue: $newValue")
        if(newValue.contains("Demo"))
            true
        else
            false
    }


}