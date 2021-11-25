package com.example.caritas.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.caritas.model.entities.User
import com.example.caritas.model.entities.UserLogin

@Dao
interface UsersDao {

    // Find mail and pass for login
    @Query(value = "SELECT * FROM UserLogin WHERE MailLogin LIKE :mail LIMIT 1")
    fun findByMail(mail: String)

    @Query(value = "SELECT * FROM user WHERE mail LIKE :mail LIMIT 1")
    fun displayUser(mail: String): User

    @Query()
    fun getPerfil()

    @Query()
    fun saveChangesPerfil()

    @Query()
    fun getDonaciones()

    // Solo para pruebas
    @Insert
    fun insertUser(user: User)

    @Insert
    fun insertMailPass(pass: UserLogin)

    @Update
    fun updateUser(user: User)
}