package com.example.caritas.model.dao

import android.widget.TextView
import androidx.room.*
import com.example.caritas.R
import com.example.caritas.model.entities.User
import com.example.caritas.model.entities.UserLogin
import java.util.*

@Dao
interface UsersDao {

    // Find mail and pass for login
    @Query(value = "SELECT * FROM UserLogin WHERE MailLogin LIKE :mail LIMIT 1")
    fun findByMail(mail: String) : UserLogin

    @Query(value = "SELECT * FROM user WHERE mail LIKE :mail LIMIT 1")
    fun displayUser(mail: String): User

    // Solo para pruebas
    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertMailPass(pass: UserLogin)

    @Update
    fun updateUser(user: User)
}



