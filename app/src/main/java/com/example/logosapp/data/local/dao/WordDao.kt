package com.example.logosapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.logosapp.data.local.model.WordEntity

@Dao
interface WordDao {
    @Insert
    suspend fun insertWords(logo: WordEntity)

    @Query("Select * from words")
    suspend fun getAllWords(word: String): List<WordEntity>
}