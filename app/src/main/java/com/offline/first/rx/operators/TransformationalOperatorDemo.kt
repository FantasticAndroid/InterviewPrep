package com.offline.first.rx.operators

import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

private const val TAG = "TransformOperatorDemo"

object TransformationalOperatorDemo {

    fun applyBufferOperator() {
        val obs = Observable.fromIterable((1..1000).asIterable())
            .buffer(10)

        val disposable = Observable.zip(
            obs,
            Observable.interval(1, TimeUnit.SECONDS)
        ) { first, second ->
            first
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe {
            Log.d(TAG, "applyBufferOperator: result: $it")
        }
    }

    fun applyScanOperator() {

        val disposable = Observable.just(1, 2, 3, 4, 5)
            .scan { total, next ->
                total + next
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : Observer<Int> {
                override fun onSubscribe(d: Disposable) {
                    Log.d(TAG, "onSubscribe")
                }

                override fun onNext(t: Int) {
                    Log.d(TAG, "applyScanOperator onNext: item: $t")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, "onError e: ${e.message}")
                }

                override fun onComplete() {
                    Log.d(TAG, "onComplete")
                }
            })
    }

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
    }

    fun applyFlatMap2() {
        data class User(val userId: String, val userName: String, var address: String? = null)

        val user1 = User("1", "Ram")
        val user2 = User("2", "Shyam")
        val user3 = User("3", "Sita")
        val user4 = User("4", "Govind")

        val disposable3 = Observable.just(user1, user2, user3, user4)
            .subscribeOn(AndroidSchedulers.mainThread())
            .flatMap { user ->
                user.run {
                    user.address = "Indore"
                    Observable.just(user)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                Log.d(TAG, "applyFlatMap2: user: $user")
            }
    }

    fun applyFlatMapDelay() {
        data class User(val userId: String, val userName: String, var address: String? = null)

        val user1 = User("1", "Ram")
        val user2 = User("2", "Shyam")
        val user3 = User("3", "Sita")
        val user4 = User("4", "Govind")
        val disposableDelay = Observable.just(user1, user2, user3, user4)
            //.subscribeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .flatMap { user ->
                user.run {
                    user.address = "Indore"
                    if (user.userId == "2") {
                        Observable.just(user).delay(1, TimeUnit.SECONDS)
                    } else {
                        Observable.just(user)
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                Log.d(TAG, "applyFlatMapDelay: user: $user")
            }
    }

    fun applySwitchMap2() {
        data class User(val userId: String, val userName: String, var address: String? = null)

        val user1 = User("1", "Ram")
        val user2 = User("2", "Shyam")
        val user3 = User("3", "Sita")
        val user4 = User("4", "Govind")

        val disposable3 = Observable.just(user1, user2, user3, user4)
            .subscribeOn(AndroidSchedulers.mainThread())
            .switchMap { user ->
                user.run {
                    user.address = "Indore"
                    Observable.just(user)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                Log.d(TAG, "applySwitchMap2: user: $user")
            }
    }

    /**
     * SwitchMap is similar to flatMap, but it only retains the result of the latest observable.
     * It discards the previous ones.
     * SwitchMap unsubscribes from the previous source Observable when new items start emitting.
     * It always emits the items from the current Observable.
     */
    fun applySwitchMapDelay() {
        data class User(val userId: String, val userName: String, var address: String? = null)

        val user1 = User("1", "Ram")
        val user2 = User("2", "Shyam")
        val user3 = User("3", "Sita")
        val user4 = User("4", "Govind")
        val disposableDelay = Observable.just(user1, user2, user3, user4)
            //.subscribeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .switchMap { user ->
                user.run {
                    user.address = "Indore"
                    if (user.userId == "3") {
                        Observable.just(user).delay(1, TimeUnit.SECONDS)
                    } else {
                        Observable.just(user)
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { user ->
                Log.d(TAG, "applySwitchMapDelay: user: $user")
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

        /*val cd = CompositeDisposable()
        cd.add(disposable1)
        cd.add(disposable2)
        cd.add(disposable3)
        // Nothing will happen if
        cd.dispose()*/
    }

}