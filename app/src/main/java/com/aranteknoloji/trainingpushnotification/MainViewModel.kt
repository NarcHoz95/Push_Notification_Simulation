package com.aranteknoloji.trainingpushnotification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.aranteknoloji.trainingpushnotification.room.RoomModel
import com.aranteknoloji.trainingpushnotification.room.database
import kotlinx.coroutines.*

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val myDatabase by lazy { database(app) }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun setTextToDb(text: String) {
        uiScope.launch {
            myDatabase.roomDao().insertText(RoomModel(text = text))
        }
    }

    fun textObservable() = Transformations.map(myDatabase.roomDao().text()) {
        it ?: RoomModel(text = "Hello World")
    }
}