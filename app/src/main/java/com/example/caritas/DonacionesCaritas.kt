package com.example.caritas

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.caritas.model.database.DbEntryPoint

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

        val dbInstance = DbEntryPoint.getDatabase(requireContext())
        val userDao = dbInstance.userDao()
        val currEmail = getCurrSession()
        val currUser = userDao.displayUser(currEmail)
        dbInstance.close()

        var nombre : TextView = view.findViewById(R.id.nombre_donaciones)

        var tipoDonante : TextView = view.findViewById(R.id.datoTipoDonante)
        var estatusDonante : TextView = view.findViewById(R.id.datoEstatusDonante)
        var importe : TextView = view.findViewById(R.id.datoImporte)
        var fechaImporte : TextView = view.findViewById(R.id.datoFechaDonaciones)

        var name : String = currUser.name
        var apellido : String = currUser.apellidoPat
        var apellido2 : String = currUser.apellidoMat
        var finalName : String = name + " " + apellido + " " + apellido2


        var hardcode1 : String = currUser.tipoDonante.toString()
        var hardcode2 : String = currUser.estatusDonante.toString()
        var hardcode3 : String = currUser.importeUltDonacion.toString()
        var hardcode4 : String = currUser.fechaUltDonacion

        nombre.setText(finalName)
        estatusDonante.setText(hardcode1)
        tipoDonante.setText(hardcode2)
        importe.setText(hardcode3)
        fechaImporte.setText(hardcode4)

        var regre : Button = view.findViewById(R.id.regresar)

        regre.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.mainMenu)
        }

    }

    private fun getCurrSession() : String {
        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        return pref.getString("sessionEmail","").toString()
    }

}