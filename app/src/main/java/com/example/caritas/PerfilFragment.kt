package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation

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

        var edit : Button = view.findViewById(R.id.editar)

        edit.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.editarPerfil)
        }


        var nombre : TextView = view.findViewById(R.id.nombre_perfil)

        var correo : TextView = view.findViewById(R.id.correoPerfil)
        var fechaNac : TextView = view.findViewById(R.id.fechaNac)
        var genero : TextView = view.findViewById(R.id.genero)
        var telMovil : TextView = view.findViewById(R.id.telMovil)
        var telCasa : TextView = view.findViewById(R.id.telCasa)

        var name : String = "Jose"
        var apellido : String = "Lopez"
        var apellido2 : String = "Martinez"
        var finalName : String = name + " " + apellido + " " + apellido2


        var hardcode1 : String = "joloma@gmail.com"
        var hardcode2 : String = "08/12/2000"
        var hardcode3 : String = "Hombre"
        var hardcode4 : String = "123-123-1234"
        var hardcode5 : String = "123-456-7890"

        nombre.setText(finalName)
        correo.setText(hardcode1)
        fechaNac.setText(hardcode2)
        genero.setText(hardcode3)
        telMovil.setText(hardcode4)
        telCasa.setText(hardcode5)


    }
}