package com.aranteknoloji.trainingpushnotification

import com.aranteknoloji.trainingpushnotification.room.RoomModel
import com.aranteknoloji.trainingpushnotification.room.database
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyFireBaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)
        println("New Token -> $newToken")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        println("Message -> ${remoteMessage.from}")
        GlobalScope.launch {
            remoteMessage.data["text"]?.let { save(it) }
        }
    }

    private suspend fun save(text: String) {
        database(this).roomDao().insertText(RoomModel(text = text))
    }
}