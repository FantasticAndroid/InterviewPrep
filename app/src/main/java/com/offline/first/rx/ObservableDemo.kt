package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val TAG = "ObservableDemo"

/**
 * Observable:- Represents a stream of data that can emit zero or more items,
 * and optionally terminates with either a completion or an error.
 * Observable is commonly used when dealing with asynchronous data streams
 * or events that can emit multiple items.
 */
object ObservableDemo {

    fun applyObservableDemo1() {

        val disposable = Observable.just("Tiger", "Lion", "Element")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onNext(t: String) {
                    Log.d(TAG, "onNext output: ${t}")
                }
            })
    }

    fun applyObservableDemo2(){
        val disposable = Observable.just("Tiger", "Lion", "Element")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item -> Log.d(TAG, "onNext output: ${item}") }, // This is onNext Block
                { error -> Log.e(TAG, "onError e: ${error.message}") }, // This is onError Block
                { Log.d(TAG, "onComplete") }  // This is onComplete Block
            )
    }

    fun applyObservableDemo3() {

        val disposable = Observable.just("Tiger", "Lion", "Element")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "ObservableDemo: ${it}")
            }
    }

    fun applyObservableDemo4() {
        val iterable = arrayOf("Tiger", "Lion", "Element").asIterable()
        val disposable = Observable.fromIterable(iterable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "ObservableDemo: $it")
            }
    }

    fun applyObservableDemo5() {
        val iterable = arrayOf("Tiger", "Lion", "Element")
        val disposable = Observable.fromArray(*iterable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "ObservableDemo: $it")
            }
    }

    fun applyObservableDemo6() {
        val disposable = Observable.interval(2, 5, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "applyObservableDemo6: $it")
            }
    }

}