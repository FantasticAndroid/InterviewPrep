package com.offline.first.rx

import android.app.ActivityManager
import android.util.Log
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates
import kotlin.system.measureTimeMillis

private const val TAG = "OperatorsDemo"

/**
 * https://abhiappmobiledeveloper.medium.com/rxjava-operators-understanding-map-flatmap-switchmap-and-concatmap-d88633f83b32#:~:text=SwitchMap%20is%20a%20bit%20different,the%20items%20from%20current%20Observable.
 */
object OperatorsDemo {


}