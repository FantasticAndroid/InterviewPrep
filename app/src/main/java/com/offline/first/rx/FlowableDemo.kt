package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Flowable:- Like Observable with Backpressure support
 * https://blog.hotstar.com/handling-backpressue-in-rxjava-4d6383113688
 */
private const val TAG = "FlowableDemo"
object FlowableDemo {

    fun applyFlowableDemo1() {


        val disposable = Observable.range(1, 1_000_000)
            .toFlowable(BackpressureStrategy.DROP)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Subscriber<Int>{
                override fun onSubscribe(s: Subscription?) {
                    Log.d(TAG, "onSubscribe: $s")
                }

                override fun onError(t: Throwable?) {
                    Log.e(TAG, "onError throwbale: ${t?.message}")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onNext(t: Int?) {
                    Log.d(TAG, "onNext item: $t")
                }

            })
    }


}