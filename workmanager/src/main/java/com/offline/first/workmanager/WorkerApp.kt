package com.offline.first.workmanager

import android.app.Application
import androidx.work.Configuration
import java.util.concurrent.Executors

open class WorkerApp : Application() , Configuration.Provider{
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setExecutor(Executors.newSingleThreadExecutor())
            .setMinimumLoggingLevel(3)
            .build()
    }
}