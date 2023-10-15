package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Completable:- Represents an asynchronous operation that either
 * completes successfully without emitting any item or terminates with an error.
 *
 * Subscribers of a Completable only need to handle the completion event or an error,
 * as it does not emit any items.
 * Completable is useful when you are only interested in the completion status of an operation,
 * rather than receiving data.
 */
private const val TAG = "CompletableDemo"

object CompletableDemo {

    fun applyCompletableDemo1() {

        val disposable = Completable.create {
            it.onComplete()
            it.onError(Exception("Exception Message"))
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }
            })
    }

    fun applyCompletableDemo2() {
        val disposable = Completable.create {
            it.onComplete()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { Log.d(TAG, "onComplete") }
    }

    fun applyCompletableDemo3() {

        val disposable = Completable.create {
            it.onComplete()
            it.onError(NullPointerException("Null Message"))
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d(TAG, "onComplete") },
                { error -> Log.e(TAG, "onError e: ${error.message}") } // This is onError Block
            )
    }

}