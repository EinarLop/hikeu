package com.example.cloudnotes
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hikeu.HikeuDao
import com.example.hikeu.OfficialTrails
import com.example.hikeu.UnOfficialTrails
import com.example.hikeu.Users

@Database(entities= [OfficialTrails::class, UnOfficialTrails::class, Users::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun MainDao(): HikeuDao
}