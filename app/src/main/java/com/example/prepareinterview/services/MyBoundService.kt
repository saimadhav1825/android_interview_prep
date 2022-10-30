package com.example.prepareinterview.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MyBoundService : Service() {
    private var myServiceBinder = MyServiceBinder()
    override fun onBind(p0: Intent?): IBinder? {
        return myServiceBinder
    }

    fun getProgress(): Flow<Float> {
        var progress = 0f
        return flow {
            while (progress < 1.0f) {
                progress +=.1f
                delay(1000)
                emit(progress)
            }
        }
    }

    inner class MyServiceBinder : Binder() {
        fun gerService() = this@MyBoundService
    }
}