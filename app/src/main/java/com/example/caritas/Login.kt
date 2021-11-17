package com.example.caritas

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*


class Login : Fragment() {
    lateinit var emailForm : EditText
    lateinit var contraForm : EditText

    var emaily : String = ""
    var contra : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        val editor = pref.edit()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Ingresar.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.mainMenu)
        }

        clickaqui.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.restablecerContra)
        }

        invitado.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.menuInvitados)
        }

    }


    private fun loadValues() {

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        emaily = pref.getString("email","").toString()
        contra = pref.getString("contra","").toString()

        emailForm.setText(emaily)
        contraForm.setText(contra)

    }


    private fun saveValues() {
        emaily = emailForm.text.toString()
        contra = contraForm.text.toString()

        var pref : SharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);
        val editor = pref.edit()

        editor.putString("email",emaily)
        editor.putString("contra",contra)

        editor.commit()
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return if (target == null) {
            false
        } else {
            Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

}