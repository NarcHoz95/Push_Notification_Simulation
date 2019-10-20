package com.aranteknoloji.trainingpushnotification.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyTable")
class RoomModel (
    @PrimaryKey
    val id: Int = 0,
    val text: String
)