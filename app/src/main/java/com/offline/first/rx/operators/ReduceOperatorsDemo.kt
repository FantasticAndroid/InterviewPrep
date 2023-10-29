package com.offline.first.rx.operators

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

private const val TAG = "ReduceOperatorsDemo"

/**
 * https://mouaad.aallam.com/rxjava-reducing-operators/
 */
object ReduceOperatorsDemo {

    /**
     * Count operator will count number of emissions and emit through a Single once onComplete() is called:
     */
    fun applyCountOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .count()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : SingleObserver<Long> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }

                override fun onSuccess(t: Long) {
                    Log.d(TAG, "applyCountOperator onSuccess, result: $t")
                }
            })
    }

    /**
     * The reduce() operator is syntactically identical to scan(),
     * but it only emits the final accumulation when the source calls onComplete().
     * It’s possible to pass a seed argument that will serve as the initial value to accumulate on.
     * The seed value should be immutable.
     * (collect() or seedWith() should be used for mutables).
     */
    fun applyReduceOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .reduce { total, next ->
                //total will result = 1
                //next   will result = 5
                total + next // 1+2+3+4+5 = 15
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : MaybeObserver<Int> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }

                override fun onSuccess(t: Int) {
                    Log.d(TAG, "applyReduceOperator onSuccess, result: $t")
                }
            })
    }

    /**
     * All operator verifies that each emission qualifies with a specified condition and return a Single<Boolean>
     * Calling all() on an empty Observable, will emit true due
     */
    fun applyAllOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .all { emitted ->
                emitted > 0
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isAllSatisfied ->
                Log.d(TAG, "applyAllOperator isAllSatisfied: $isAllSatisfied")
            }
    }

    /**
     * This operator will check whether at least one emission meets a specific criterion
     * and return a Single<Boolean>.
     * Calling any() on an empty Observable, will emit false.
     */
    fun applyAnyOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .any { emitted ->
                emitted/5 == 0
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isAnySatisfied ->
                Log.d(TAG, "applyAnyOperator isAnySatisfied: $isAnySatisfied")
            }
    }

    fun applyContainsOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .contains(0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isContain ->
                Log.d(TAG, "applyContainsOperator isContain: $isContain")
            }
    }


}