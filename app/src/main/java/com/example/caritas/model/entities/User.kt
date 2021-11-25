package com.example.caritas.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "User_Id") val id: Int,
    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Surname1") val apellidoPat: String,
    @ColumnInfo(name = "Surname2") val apellidoMat: String,
    @ColumnInfo(name = "Age") val age: Int,
    @ColumnInfo(name = "Gender") val gender: String,
    @ColumnInfo(name = "Mail") val mail: String,
    @ColumnInfo(name = "Donations") val donation: Float,
        )