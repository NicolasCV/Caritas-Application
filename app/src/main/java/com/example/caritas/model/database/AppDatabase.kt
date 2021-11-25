package com.example.caritas.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.caritas.model.dao.UsersDao
import com.example.caritas.model.entities.User
import com.example.caritas.model.entities.UserLogin

@Database(entities = arrayOf((User::class), (UserLogin::class)), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UsersDao
}