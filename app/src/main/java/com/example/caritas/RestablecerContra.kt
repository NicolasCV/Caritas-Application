package com.example.caritas

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import java.util.regex.Matcher
import java.util.regex.Pattern
import android.widget.Toast



class RestablecerContra : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restablecer_contra, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var ingresar : Button = view.findViewById(R.id.Ingresar)
        var inputForm : EditText = view.findViewById(R.id.correoInput)
        var input : String = ""

        ingresar.setOnClickListener{

            input = inputForm.text.toString()

            if(!isValidEmail(input)){
                Toast.makeText(activity, "Debe ser un correo valido", Toast.LENGTH_SHORT).show()
            }

            else{
                Navigation.findNavController(view).navigate(R.id.login)
            }

        }

    }

    private fun isValidEmail(email: String?): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}