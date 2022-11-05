package com.example.prepareinterview.pushnotifciation

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.prepareinterview.MainActivity
import com.example.prepareinterview.R
import java.util.*

class NotificationHelper(private val context: Context) {
    private lateinit var notificationManager: NotificationManager
    private lateinit var notificationBuilder: NotificationCompat.Builder

    /**
     * Create and push the notification
     */
    fun createChatNotification(/*chatNotificationResponse: ChatNotificationResponse*/title: String?, body: String?) {
        notificationBuilder = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher)
        val args = Bundle()
        val resultPendingIntent: PendingIntent =
                    getMatchedPendingIntent(args)

        notificationBuilder.setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setOngoing(false)
            .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
            .setContentIntent(resultPendingIntent)

        notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val notificationChannel =
                NotificationChannel(NOTIFICATION_CHANNEL_ID, "Chats", importance)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(true)
            notificationChannel.vibrationPattern =
                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            notificationBuilder.setChannelId(NOTIFICATION_CHANNEL_ID)
            notificationManager.createNotificationChannel(notificationChannel)
        }
        val id = Random(System.currentTimeMillis()).nextInt(1000)
        notificationManager.notify(id, notificationBuilder.build())
    }

    private fun getMatchedPendingIntent(args: Bundle): PendingIntent {
        return createNotificationPendingIntent(
            R.navigation.mobile_navigation,
            R.id.navigation_dashboard,
            args
        )
    }

    private fun createNotificationPendingIntent(
        graph: Int,
        destination: Int,
        args: Bundle
    ): PendingIntent {
        return NavDeepLinkBuilder(context)
            .setGraph(graph)
            .setDestination(destination)
            .setArguments(args)
            .setComponentName(MainActivity::class.java)
            .createPendingIntent()
    }

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "10001"
    }
}