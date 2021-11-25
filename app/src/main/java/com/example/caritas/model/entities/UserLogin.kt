package com.example.caritas.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity (foreignKeys = arrayOf(
    ForeignKey(entity = User::class,
    parentColumns = arrayOf("Mail"),
    childColumns = arrayOf("MailLogin"),
    onUpdate = ForeignKey.CASCADE)
))
data class UserLogin (
    @ColumnInfo(name = "MailLogin") val mail: String,
    @ColumnInfo(name = "Pass") val password: String,
        )