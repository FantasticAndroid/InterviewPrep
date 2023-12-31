package com.offline.first.workmanager.workers

import android.content.Context
import android.util.Log
import androidx.work.WorkerParameters
import androidx.work.rxjava3.RxWorker
import com.offline.first.workmanager.OUTPUT_PATH
import io.reactivex.rxjava3.core.Single
import java.io.File

private const val TAG = "CleanupRxWorker"
class CleanupRxWorker(ctx: Context, params: WorkerParameters) : RxWorker(ctx, params) {

    override fun createWork(): Single<Result> {
        // Makes a notification when the work starts and slows down the work so that
        // it's easier to see each WorkRequest start, even on emulated devices
        makeStatusNotification("Cleaning up old temporary files", applicationContext)
        sleep()

        val result = try {
            cleanUpTask()
            Result.success()
        } catch (exception: Exception) {
            exception.printStackTrace()
            Result.failure()
        }
        return Single.just(result)
    }
    private fun cleanUpTask() {
        val outputDirectory = File(
            applicationContext.filesDir, OUTPUT_PATH
        )
        if (outputDirectory.exists()) {
            val entries = outputDirectory.listFiles()
            if (entries != null) {
                for (entry in entries) {
                    val name = entry.name
                    if (name.isNotEmpty() && name.endsWith(".png")) {
                        val deleted = entry.delete()
                        Log.i(TAG, "Deleted $name - $deleted")
                    }
                }
            }
        }
    }
}