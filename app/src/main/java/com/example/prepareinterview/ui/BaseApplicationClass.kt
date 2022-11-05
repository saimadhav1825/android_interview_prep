package com.example.prepareinterview.ui

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

@HiltAndroidApp
class BaseApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        instance = this
        initFirebaseMessagingService()
    }

    companion object {
        @get:Synchronized
        var instance: BaseApplicationClass? = null
            private set
        val appContext: Context
            get() = instance!!.applicationContext
    }

    private fun initFirebaseMessagingService() {
        //Initialize FireBase
        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }
            // Get new FCM registration token
            val token = task.result
            runBlocking(Dispatchers.IO) {
                Log.d("Device Token", "Token $token")
            }
        })
    }
}