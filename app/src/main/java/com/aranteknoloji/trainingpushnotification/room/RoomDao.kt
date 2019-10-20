package com.aranteknoloji.trainingpushnotification.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(roomModel: RoomModel)

    @Query("select * from MyTable")
    fun text(): LiveData<RoomModel>
}