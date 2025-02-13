package com.example.logosapp.data.local.dao

import androidx.room.Insert
import com.example.logosapp.data.local.model.LogoEntity

interface LogoDao {
    @Insert
    fun insertLogos() : List<LogoEntity>
}