package com.offline.first.rx

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val TAG = "OperatorsDemo"

/**
 * https://abhiappmobiledeveloper.medium.com/rxjava-operators-understanding-map-flatmap-switchmap-and-concatmap-d88633f83b32#:~:text=SwitchMap%20is%20a%20bit%20different,the%20items%20from%20current%20Observable.
 */
object OperatorsDemo {

    fun applyMapOperator() {
        val disposable = Observable.just("Tiger", "Lion", "Panther")
            .subscribeOn(Schedulers.io())
            .map { it.length }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { length ->
                Log.d(TAG, "applyMapOperator: length: $length")
            }

        val disposable2 = Observable.just("Tiger animal", "Lion animal", "Panther animal")
            .subscribeOn(Schedulers.io())
            .map { it.split(" ") }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { splitList ->
                Log.d(TAG, "applyMapOperator: splitList: $splitList")
            }
    }

    fun applyFlatMap() {
        val disposable = Observable.just("Tiger", "Lion", "Panther")
            .subscribeOn(Schedulers.io())
            .flatMap { animal -> Observable.fromArray(animal.toCharArray()) }
            .map {
                it.size
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "applyFlatMap: length: $it")
            }

        val disposable2 = Observable.just("Tiger animal", "Lion animal", "Panther animal")
            .subscribeOn(Schedulers.io())
            .flatMap { Observable.fromArray(it.split(" ")) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { splitList ->
                Log.d(TAG, "applyFlatMap: splitList: $splitList")
            }

        /********************/
        data class User(val userId: String, val userName: String, var address: String? = null)

        val user1 = User("1", "Ram")
        val user2 = User("2", "Shyam")
        val user3 = User("3", "Sita")

        val disposable3 = Observable.just(user1, user2, user3)
            .subscribeOn(Schedulers.io())
            .flatMap { user ->
                user.run {
                    user.address = "Indore"
                    Observable.just(user)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                Log.d(TAG, "applyFlatMap: user: $user")
            }
    }

    /**
     * SwitchMap is best suited when you want to discard the response and consider the latest one.
     * Choose FlatMap when the order is not important.
     *
     */
    fun applySwitchMap() {
        val disposable1 = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
            .subscribeOn(Schedulers.io())
            .switchMap { number ->
                number.run {
                    Observable.just(number * 2).delay(1, TimeUnit.SECONDS)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item ->
                    Log.d(
                        TAG,
                        "applySwitchMap onNext output: $item"
                    )
                }, // This is onNext Block
                { error ->
                    Log.e(
                        TAG,
                        "applySwitchMap onError e: ${error.message}"
                    )
                }, // This is onError Block
                { Log.d(TAG, "applySwitchMap onComplete") }  // This is onComplete Block
            )

        val disposable2 = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
            .subscribeOn(Schedulers.io())
            .flatMap { number ->
                number.run {
                    Observable.just(number * 2).delay(1, TimeUnit.SECONDS)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item -> Log.d(TAG, "applyFlatMap onNext output: $item") }, // This is onNext Block
                { error ->
                    Log.e(
                        TAG,
                        "applyFlatMap onError e: ${error.message}"
                    )
                }, // This is onError Block
                { Log.d(TAG, "applyFlatMap onComplete") }  // This is onComplete Block
            )

        val disposable3 = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8)
            .subscribeOn(Schedulers.io())
            .concatMap { number ->
                number.run {
                    Observable.just(number * 2).delay(1, TimeUnit.SECONDS)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { item ->
                    Log.d(
                        TAG,
                        "applyConcatMap onNext output: $item"
                    )
                }, // This is onNext Block
                { error ->
                    Log.e(
                        TAG,
                        "applyConcatMap onError e: ${error.message}"
                    )
                }, // This is onError Block
                { Log.d(TAG, "applyConcatMap onComplete") }  // This is onComplete Block
            )

        val cd = CompositeDisposable()
        cd.add(disposable1)
        cd.add(disposable2)
        cd.add(disposable3)
        // Nothing will happen if
        cd.dispose()
    }

    fun applyFilter() {

        val disposable = Observable.just(100, 300, 800, 1100, 33, 99, 222)
            .filter { item -> item < 100 }
            .subscribe { result -> println("Selected items are $result") }

    }

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
        // OutPut -> Ram age is 36, Shyam age is 35
    }

    fun applyConcat() {
        val disposable = Observable.concat(
            Observable.just("Ram", "Shyam", "Sita", "Govind"),
            Observable.just(36, 35)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d(TAG, "applyConcat Item: $result") }
        // OutPut -> Ram, Shyam, "Sita", "Govind", 36, 35
    }

    fun applyMerge() {
        val disposable = Observable.merge(
            Observable.just("Ram", "Shyam", "Sita", "Govind"),
            Observable.just(36, 35)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d(TAG, "applyMerge Item: $result") }
        // OutPut -> Ram, Shyam, "Sita", "Govind", 36, 35
    }

    fun applyCombineLatest() {
        val observable1 = Observable.interval(2, TimeUnit.SECONDS)
        val observable2 = Observable.interval(2, TimeUnit.SECONDS)

        val disposable = Observable.combineLatest(
            observable1, observable2
        ) { observable1Times: Long, observable2Times: Long -> "Refreshed Observable1: $observable1Times refreshed Observable2: $observable2Times" }
            .subscribe { time: String? ->
                Log.d(TAG, "applyCombineLatest time: $time")
            }
    }
}