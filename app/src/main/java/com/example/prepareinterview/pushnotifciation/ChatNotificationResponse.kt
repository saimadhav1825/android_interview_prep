package com.example.prepareinterview.pushnotifciation


data class ChatNotificationResponse(
    val toUser: String? = null,
    val fromUser: String? = null,
    val action: String? = null,
    val notificationType: String? = null,
    val title: String? = null,
    val content: String? = null,
    val isSubscribed: Boolean = false
)
