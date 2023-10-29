package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


private const val TAG = "SingleDemo"
/**
 * Single:- Represents a stream that emits a single item or an error.
 *
 * Single type of Observable is used when you have to return a single item
 * Item will be returned when onSuccess will be called.
 * If there is any error occurs then it will call onError
 */
object SingleDemo {

    fun applySingleDemo1() {

        val disposable = Single.just("Tiger")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : SingleObserver<String> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onSuccess(item: String) {
                    Log.d(TAG, "onSuccess: item: ${item}")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }
            })
    }

    fun applySingleDemo2(){
        val disposable = Single.just("Tiger")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item -> Log.d(TAG, "onSuccess output: ${item}") }, // This is onSuccess Block
                { error -> Log.e(TAG, "onError e: ${error.message}") }, // This is onError Block
            )
    }

    fun applySingleDemo3() {

        val animals = arrayOf("Tiger")
        val disposable = Single.just(animals)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { item ->
                Log.d(TAG, "SingleDemo: ${item}")
            }
    }

}