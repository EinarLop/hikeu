package com.example.cloudnotes
import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hikeu.HikeuDao
import com.example.hikeu.OfficialTrails
import com.example.hikeu.UnOfficialTrails
import com.example.hikeu.Users

@Database(entities= [OfficialTrails::class, UnOfficialTrails::class, Users::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun MainDao(): HikeuDao
    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "hikeu")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance

            }


        }


    }
}