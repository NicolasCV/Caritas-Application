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
import com.example.caritas.model.entities.User

class PerfilFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbInstance = DbEntryPoint.getDatabase(requireContext())
        val userDao = dbInstance.userDao()

        val currEmail = getCurrSession()

        val currUser = userDao.displayUser(currEmail)
        dbInstance.close()


        var nombre : TextView = view.findViewById(R.id.nombre_perfil)

        var correo : TextView = view.findViewById(R.id.correoPerfil)
        var fechaNac : TextView = view.findViewById(R.id.fechaNac)
        var genero : TextView = view.findViewById(R.id.genero)
        var telMovil : TextView = view.findViewById(R.id.telMovil)
        var telCasa : TextView = view.findViewById(R.id.telCasa)

        var name : String = currUser.name
        var apellido : String = currUser.apellidoPat
        var apellido2 : String = currUser.apellidoMat
        var finalName : String = name + " " + apellido + " " + apellido2


        var hardcode1 : String = currEmail
        var hardcode2 : String = currUser.fechaDeNacimiento
        var hardcode3 : String = currUser.gender
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
            Navigation.findNavController(view).navigate(R.id.editarPerfil)
        }


    }

    private fun getCurrSession() : String {
        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        return pref.getString("sessionEmail","").toString()
    }

}

