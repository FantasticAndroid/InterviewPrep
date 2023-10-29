package com.offline.first.workmanager.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.offline.first.workmanager.OUTPUT_PATH
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

private const val TAG = "CleanupCoroutineWorker"

class CleanupCoroutineWorker(ctx: Context, params: WorkerParameters) :
    CoroutineWorker(ctx, params) {

    override suspend fun doWork(): Result {
        // Makes a notification when the work starts and slows down the work so that
        // it's easier to see each WorkRequest start, even on emulated devices
        makeStatusNotification("Cleaning up old temporary files", applicationContext)
        sleep()

        return withContext(Dispatchers.IO) {
            try {
                cleanUpTask()
                Result.success()
            } catch (exception: Exception) {
                exception.printStackTrace()
                Result.failure()
            }
        }
    }

    private fun cleanUpTask() {
        val outputDirectory = File(applicationContext.filesDir, OUTPUT_PATH)
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