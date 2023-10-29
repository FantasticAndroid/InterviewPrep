package com.offline.first.rx.operators

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val TAG = "CombiningOperatorsDemo"

/**
 * https://proandroiddev.com/exploring-rxjava-in-android-operators-for-combining-observables-25734080f4be
 */
object CombiningOperatorsDemo {

    fun applySwitchOnNext() {

        val disposable = Observable
            /* This is the outer observable.
             * Items emitted here will be used to control the inner observable.
             * Whenever it emits an item, the inner observable will stop its emission
             * and a new one will be created.
             */
            .switchOnNext(
                Observable.interval(600, TimeUnit.MILLISECONDS)
                    .map { aLong: Long? ->
                        Observable.interval(
                            180,
                            TimeUnit.MILLISECONDS
                        )
                    })
            .subscribe { item: Long ->
                Log.d(TAG, "applySwitchOnNext result: $item")
            }
    }

    /**
     * Zip First observer's Nth emitted with Second observer's Nth emitted
     * Complete when First observer's Nth or Second observer Nth not available.
     * Result -> Ram age is 36, Shyam age is 35
     */
    fun applyZip() {

        val disposable = Observable.zip(
            Observable.just("Ram", "Shyam", "Sita", "Govind"),
            Observable.just(36, 35)
        ) { name, age ->
            "$name age is $age"
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d(TAG, "Item: $result") }
    }

    /**
     * Concat and merge result the same but
     * Concat waits for one Observable to complete before it starts the next one.
     * Result -> Ram, Shyam, "Sita", "Govind", 36, 35, 40, 45, 50
     */
    fun applyConcat() {

        val disposable = Observable.concat(
            Observable.just("Ram", "Shyam", "Sita", "Govind"),
            Observable.just(36, 35, 40, 45, 50)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d(TAG, "applyConcat Item: $result") }
    }

    /**
     * Concat and merge result the same but
     * Merge run asynchronusly
     * Result -> Ram, Shyam, "Sita", "Govind", 36, 35, 40, 45, 50
     */
    fun applyMerge() {
        val disposable = Observable.merge(
            Observable.just("Ram", "Shyam", "Sita", "Govind"),
            Observable.just(36, 35, 40, 45, 50)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d(TAG, "applyMerge Item: $result") }
    }

    fun applyCombineLatest() {
        val observable1 = Observable.interval(2, TimeUnit.SECONDS)
        val observable2 = Observable.interval(1, TimeUnit.SECONDS)

        val disposable = Observable.combineLatest(
            observable1, observable2
        ) { observable1Times: Long, observable2Times: Long -> "Refreshed Observable1: $observable1Times refreshed Observable2: $observable2Times" }
            .subscribe { time: String? ->
                Log.d(TAG, "applyCombineLatest time: $time")
            }
    }

    /**
     * Result-> (5:b:A), (5:b:B), (5:b:C)
     */
    fun applyCombineLatest2() {
        val observable1 = Observable.just(1, 2, 3, 4, 5)
        val observable2 = Observable.just('a', 'b')
        val observable3 = Observable.just("A", "B", "C")

        val disposable = Observable.combineLatest(
            observable1, observable2, observable3
        ) { item1: Int, item2: Char, item3: String ->
            /*"item1:$item1, item2:$item2, item3:$item3"*/ "$item1:$item2:$item3"
        }
            .subscribe { combine: String ->
                Log.d(TAG, "applyCombineLatest2 combine: $combine")
            }
    }
}