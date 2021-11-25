package com.example.caritas.model.database

import android.content.Context
import androidx.room.Room

class DbEntryPoint {
    companion object{
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "DbUserCaritas")
                .allowMainThreadQueries()
                .build();
        }
    }
}