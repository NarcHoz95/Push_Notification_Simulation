package com.aranteknoloji.trainingpushnotification.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomModel::class], version = 1)
abstract class MyDatabase: RoomDatabase() {
    abstract fun roomDao(): RoomDao
}

private var db: MyDatabase? = null

fun database(context: Context): MyDatabase = db ?:
    Room.databaseBuilder(context, MyDatabase::class.java, "my_db").build().also { db = it }