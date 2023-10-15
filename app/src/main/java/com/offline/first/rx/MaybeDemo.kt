package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

private const val TAG = "MaybeDemo"
/**
 * Maybe:- Represents a stream that can emit either a single item,
 * no item at all, or terminate with an error.
 * Subscribers of a Maybe can handle the emitted item via the onSuccess method,
 * handle the absence of an item via the onComplete method,
 * or handle an error via the onError method.
 * Maybe is suitable when you need to handle situations where the result may or may not be present.
 */
object MaybeDemo {

    fun applyMayDemo1() {

        val disposable = Maybe.just("Tiger")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : MaybeObserver<String> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onSuccess(item: String) {
                    Log.d(TAG, "onSuccess: item: ${item}")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }
            })
    }

    fun applyMayDemo2(){
        val animals = arrayOf("Tiger", "Lion", "Element")
        val disposable = Maybe.just(animals)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item -> Log.d(TAG, "onSuccess output: ${item.toList()}") }, // This is onSuccess Block
                { error -> Log.e(TAG, "onError e: ${error.message}") }, // This is onError Block
            )
    }

    fun applyMayDemo3(){
        val disposable = Maybe.just("Tiger")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item -> Log.d(TAG, "onSuccess output: ${item}") }, // This is onSuccess Block
                { error -> Log.e(TAG, "onError e: ${error.message}") }, // This is onError Block
                {   Log.d(TAG, "onComplete")   } // This is onComplete block
            )
    }

    fun applyMayDemo4() {

        val disposable = Maybe.just("Tiger")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { item ->
                Log.d(TAG, "MayDemo: ${item}")
            }
    }

}