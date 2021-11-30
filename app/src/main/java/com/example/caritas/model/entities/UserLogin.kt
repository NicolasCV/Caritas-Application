package com.example.caritas.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity (foreignKeys = arrayOf(
    ForeignKey(entity = User::class,
        parentColumns = arrayOf("User_Id"),
        childColumns = arrayOf("User_Id"),
        onUpdate = ForeignKey.CASCADE)
))
data class UserLogin (

    @PrimaryKey @ColumnInfo(name = "User_Id") val id: Int,
    @ColumnInfo(name = "MailLogin") val mail: String,
    @ColumnInfo(name = "Pass") val password: String,
        )

/*
foreignKeys = arrayOf(
    ForeignKey(entity = User::class,
    parentColumns = arrayOf("User_Id"),
    childColumns = arrayOf("User_Id"),
    onUpdate = ForeignKey.CASCADE)
)
 */