package com.aranteknoloji.trainingpushnotification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.aranteknoloji.trainingpushnotification.room.RoomModel
import com.aranteknoloji.trainingpushnotification.room.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

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

    fun textObservable() = myDatabase.roomDao().text()
}