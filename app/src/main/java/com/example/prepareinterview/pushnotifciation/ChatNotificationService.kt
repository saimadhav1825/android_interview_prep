package com.example.prepareinterview.pushnotifciation

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ChatNotificationService :
    FirebaseMessagingService() {

    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onNewToken(fcmToken: String) {
        super.onNewToken(fcmToken)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val response = Gson().toJson(remoteMessage)
        // Check if message contains a data payload.
        val data = remoteMessage.data
      /*  if (data.isNotEmpty()) {
            val body = data["body"]
            val notificationResponse = Gson().fromJson(body, ChatNotificationResponse::class.java)
            notificationHelper.createChatNotification(notificationResponse)
        }*/
        notificationHelper.createChatNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)
        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("Message Notification Body","${it.body}")
        }
    }
}