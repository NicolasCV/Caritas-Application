package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

class DonacionesCaritas : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donaciones_caritas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var regre : Button = view.findViewById(R.id.regresar)

        regre.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.mainMenu)
        }

        var nombre : TextView = view.findViewById(R.id.nombre_donaciones)

        var tipoDonante : TextView = view.findViewById(R.id.datoTipoDonante)
        var estatusDonante : TextView = view.findViewById(R.id.datoEstatusDonante)
        var importe : TextView = view.findViewById(R.id.datoImporte)
        var fechaImporte : TextView = view.findViewById(R.id.datoFechaDonaciones)

        var name : String = "Jose"
        var apellido : String = "Lopez"
        var apellido2 : String = "Martinez"
        var finalName : String = name + " " + apellido + " " + apellido2


        var hardcode1 : String = "Moral"
        var hardcode2 : String = "Activo"
        var hardcode3 : String = "$313.13"
        var hardcode4 : String = "08/12/2021"

        nombre.setText(finalName)
        estatusDonante.setText(hardcode1)
        tipoDonante.setText(hardcode2)
        importe.setText(hardcode3)
        fechaImporte.setText(hardcode4)

    }

}