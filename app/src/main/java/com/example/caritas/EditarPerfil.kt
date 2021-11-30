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
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.caritas.model.database.DbEntryPoint
import com.example.caritas.model.entities.User
import kotlinx.android.synthetic.main.fragment_editar_perfil.*

class EditarPerfil : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_editar_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dbInstance = DbEntryPoint.getDatabase(requireContext())
        val userDao = dbInstance.userDao()

        var currEmail = getCurrSession()
        var currUser = userDao.displayUser(currEmail)




        var nombre : TextView = view.findViewById(R.id.nombre_perfil)

        //Dato correo ahora es edad
        var correo : TextView = view.findViewById(R.id.datoCorreo)
        var fechaNac : TextView = view.findViewById(R.id.datoFechaNac)
        var genero : TextView = view.findViewById(R.id.datoGenero)
        var telMovil : TextView = view.findViewById(R.id.datoTelMovil)
        var telCasa : TextView = view.findViewById(R.id.datoTelCasa)

        var name : String = currUser.name
        var apellido : String = currUser.apellidoPat
        var apellido2 : String = currUser.apellidoMat
        var finalName : String = name + " " + apellido + " " + apellido2


        var hardcode1 : String = currUser.age.toString()
        var hardcode2 : String = currUser.fechaDeNacimiento.toString()
        var hardcode3 : String = currUser.gender.toString()
        var hardcode4 : String = currUser.telefonoMovil.toString()
        var hardcode5 : String = currUser.telefonoCasa.toString()

        nombre.setText(finalName)
        correo.setText(hardcode1)
        fechaNac.setText(hardcode2)
        genero.setText(hardcode3)
        telMovil.setText(hardcode4)
        telCasa.setText(hardcode5)


        var edit : Button = view.findViewById(R.id.editar)

        edit.setOnClickListener{


            val id = currUser.id
            val name = currUser.name
            val sur1 = currUser.apellidoPat
            val sur2 = currUser.apellidoMat
            val mail = currUser.mail

            val age = datoCorreo.text.toString().toInt()
            val gender = datoGenero.text.toString()
            val birthDate = datoFechaNac.text.toString()
            val tMovil = datoTelMovil.text.toString().toLong()
            val tCasa = datoTelCasa.text.toString().toLong()


            val userToUpdate = User(id, name, sur1, sur2, mail, age, gender, birthDate, tMovil, tCasa, currUser.tipoDonante, currUser.estatusDonante, currUser.importeUltDonacion,currUser.fechaUltDonacion)
            userDao.updateUser(userToUpdate)
            Toast.makeText(activity, "Usuario Actualizado", Toast.LENGTH_SHORT).show()
            dbInstance.close()
            Navigation.findNavController(view).navigate(R.id.mainMenu)
        }


    }

    private fun getCurrSession() : String {
        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        return pref.getString("sessionEmail","").toString()
    }
}