package com.example.logosapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.logosapp.data.local.dao.WordDao
import com.example.logosapp.data.local.model.WordEntity

@Database(entities = [WordEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}
