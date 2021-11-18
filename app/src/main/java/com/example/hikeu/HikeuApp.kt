package com.example.hikeu

import android.app.Application
import com.example.cloudnotes.AppDatabase

class HikeuApp: Application(){
    val database : AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
}