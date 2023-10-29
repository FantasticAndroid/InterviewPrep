package com.offline.first.rx.operators

import io.reactivex.rxjava3.core.Observable

private const val TAG = "FilterOperatorsDemo"

/**
 * Debounce Emits items only when timeout occurs without emitting another item.
 *
 * Distinct Emits only unique items.
 *
 * ElementAt Emit only item at n index emitted by an Observable.
 *
 * Filter Emits only those items which pass the given predicate function.
 *
 * First Emits the first item or first item which passed the given criteria.
 *
 * IgnoreElements Do not emits any items from Observable but marks completion.
 *
 * Last Emits the last element from Observable.
 *
 * Sample Emits the most recent item with given time interval.
 *
 * Skip Skips the first n items from an Observable.
 *
 * SkipLast Skips the last n items from an Observable.
 *
 * Take takes the first n items from an Observable.
 *
 * TakeLast takes the last n items from an Observable.
 *
 */
object FilterOperatorsDemo {

    fun applyFilter() {
        val disposable = Observable.just(100, 300, 800, 1100, 33, 99, 222)
            .filter { item -> item < 100 }
            .subscribe { result -> println("Selected items are $result") }
    }


}