package com.aranteknoloji.trainingpushnotification

import android.app.IntentService
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.aranteknoloji.trainingpushnotification.room.RoomModel
import com.aranteknoloji.trainingpushnotification.room.database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotificationService : IntentService("My Service") {

    override fun onHandleIntent(intent: Intent?) {
        Toast.makeText(this, "onHandleIntent has been called with $intent", Toast.LENGTH_LONG).show()
        //startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.tr/search?q=${intent?.action}")))
        GlobalScope.launch {
            intent?.extras?.get("text")?.let { save(it.toString()) }
        }
    }

    private suspend fun save(text: String) {
        database(this).roomDao().insertText(RoomModel(text = text))
    }
}