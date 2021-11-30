package com.example.caritas.model.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "User_Id") val id: Int,

    @ColumnInfo(name = "Name") val name: String,
    @ColumnInfo(name = "Surname1") val apellidoPat: String,
    @ColumnInfo(name = "Surname2") val apellidoMat: String,
    @ColumnInfo(name = "Mail") val mail: String,

    //Esta informacion es para perfil + el correo (getPerfil)
    @ColumnInfo(name = "Age") val age: Int,
    @ColumnInfo(name = "Gender") val gender: String,
    @ColumnInfo(name = "FechaDeNacimiento") val fechaDeNacimiento: String,
    @ColumnInfo(name = "TelefonoMovil") val telefonoMovil: Long,
    @ColumnInfo(name = "TelefonoCasa") val telefonoCasa: Long,

    //Esta informacion es para getDonaciones
    @ColumnInfo(name = "TipoDonante") val tipoDonante: Int,
    @ColumnInfo(name = "EstatusDonante") val estatusDonante: Int,
    @ColumnInfo(name = "ImporteUltDonacion") val importeUltDonacion: Double,
    @ColumnInfo(name = "fechaUltDonacion") val fechaUltDonacion: String,


    )