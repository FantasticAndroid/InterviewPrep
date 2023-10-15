package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject

private const val TAG = "SubjectDemo"
object SubjectDemo {

    /**
     * PublishSubject emits items to currently subscribed Observers and
     * terminal events to current or late Observers.
     */
    fun applyPublishSubjectDemo(){
        val result1 = StringBuilder()
        val result2 = StringBuilder()
        val result3 = StringBuilder()

        val subject = PublishSubject.create<String>()
        val disposable1 = subject.subscribe { value: String? ->
            result1.append(value)
        }
        subject.onNext("a")
        subject.onNext("b")
        subject.onNext("c")

        val disposable2 = subject.subscribe { value: String? ->
            result2.append(value)
        }
        subject.onNext("d")
        subject.onNext("e")

        val disposable3 = subject.subscribe { value: String? ->
            result3.append(value)
        }
        subject.onNext("f")
        subject.onNext("g")

        subject.onComplete()

        Log.d(TAG, "applyPublishSubjectDemo result1: $result1")
        Log.d(TAG, "applyPublishSubjectDemo result2: $result2")
        Log.d(TAG, "applyPublishSubjectDemo result3: $result3")
    }

    /**
     * BehaviorSubject emits the most recent item it has observed and
     * then all subsequent observed items to each subscribed Observer.
     */
    fun applyBehaviorSubjectDemo(){
        val result1 = StringBuilder()
        val result2 = StringBuilder()
        val result3 = StringBuilder()

        val subject = BehaviorSubject.create<String>()
        val disposable1 = subject.subscribe { value: String? ->
            result1.append(value)
        }
        subject.onNext("a")
        subject.onNext("b")
        subject.onNext("c") // Most Recent item

        val disposable2 = subject.subscribe { value: String? ->
            result2.append(value)
        }
        subject.onNext("d")
        subject.onNext("e") // Most Recent item
        val disposable3 = subject.subscribe { value: String? ->
            result3.append(value)
        }
        subject.onNext("f")
        subject.onNext("g") // Most Recent item
        subject.onComplete()

        //Output will be abcd
        Log.d(TAG, "applyBehaviorSubjectDemo result1: $result1")
        //Output will be d only as subscribed after c item emitted.
        Log.d(TAG, "applyBehaviorSubjectDemo result2: $result2")
        Log.d(TAG, "applyBehaviorSubjectDemo result3: $result3")
    }

    /**
     * ReplaySubject replays events/items to current and late Observers.
     */
    fun applyReplaySubjectDemo(){
        val result1 = StringBuilder()
        val result2 = StringBuilder()
        val result3 = StringBuilder()

        val subject = ReplaySubject.create<String>()
        val disposable1 = subject.subscribe { value: String? ->
            result1.append(value)
        }
        subject.onNext("a")
        subject.onNext("b")
        subject.onNext("c") // Most Recent item

        val disposable2 = subject.subscribe { value: String? ->
            result2.append(value)
        }
        subject.onNext("d")
        subject.onNext("e") // Most Recent item
        val disposable3 = subject.subscribe { value: String? ->
            result3.append(value)
        }
        subject.onNext("f")
        subject.onNext("g") // Most Recent item
        subject.onComplete()

        Log.d(TAG, "applyReplaySubjectDemo result1: $result1")
        Log.d(TAG, "applyReplaySubjectDemo result2: $result2")
        Log.d(TAG, "applyReplaySubjectDemo result3: $result3")
    }

    /**
     * AsyncSubject emits the only last value followed by a completion event
     * or the received error to Observers.
     */
    fun applyAsyncSubjectDemo(){
        val result1 = StringBuilder()
        val result2 = StringBuilder()
        val result3 = StringBuilder()

        val subject = AsyncSubject.create<String>()
        val disposable1 = subject.subscribe { value: String? ->
            result1.append(value)
        }
        subject.onNext("a")
        subject.onNext("b")
        subject.onNext("c")

        val disposable2 = subject.subscribe { value: String? ->
            result2.append(value)
        }
        subject.onNext("d")
        subject.onNext("e")
        val disposable3 = subject.subscribe { value: String? ->
            result3.append(value)
        }
        subject.onNext("f")
        subject.onNext("g") // Last value followed by a completion event
        subject.onComplete()

        Log.d(TAG, "applyAsyncSubjectDemo result1: $result1")
        Log.d(TAG, "applyAsyncSubjectDemo result2: $result2")
        Log.d(TAG, "applyAsyncSubjectDemo result3: $result3")
    }

}