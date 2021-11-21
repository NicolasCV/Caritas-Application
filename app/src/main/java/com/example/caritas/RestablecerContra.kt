package com.example.caritas

import android.content.Context
import android.os.Bundle
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

            if(!isValidPassword(input)){
                Toast.makeText(activity, "Must be a valid password = Needs a symbols and an uppercase letter", Toast.LENGTH_LONG).show()
            }

            else{
                Navigation.findNavController(view).navigate(R.id.login)
            }

        }

    }

    fun isValidPassword(password: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        pattern = Pattern.compile(PASSWORD_PATTERN)
        matcher = pattern.matcher(password)
        return matcher.matches()
    }
}