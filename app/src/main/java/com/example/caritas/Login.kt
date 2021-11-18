package com.example.caritas

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace


class Login : Fragment() {
    private lateinit var textView: TextView
    private lateinit var ingresarBtn: Button
    private lateinit var invitadoBtn: Button
    private lateinit var recoveryBtn: Button
    private lateinit var fragManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragManager = parentFragmentManager

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

        ingresarBtn = view.findViewById(R.id.IngresarButton)
        invitadoBtn = view.findViewById(R.id.invitadoButton)
        recoveryBtn = view.findViewById(R.id.recoverButton)

        ingresarBtn.setOnClickListener{
            fragManager.commit{
                replace<MainMenu>(R.id.fragmentCont)
            }
        }

        invitadoBtn.setOnClickListener{
            fragManager.commit{
                replace<MenuInvitados>(R.id.fragmentCont)
            }
        }

        recoveryBtn.setOnClickListener{
            fragManager.commit{
                replace<RestablecerContra>(R.id.fragmentCont)
            }
        }

        /*
        textView = findViewById(android.R.id.clickaqui)
        val spannableString = SpannableString(string)
        spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
        textView.text = spannableString
        textView.setTextColor(Color.BLUE)

         */
    }

}