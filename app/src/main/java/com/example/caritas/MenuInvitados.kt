package com.example.caritas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation

class MenuInvitados : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_invitados, container, false)
    }
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var infoBtn : ImageView = view.findViewById(R.id.infoButton)
        var eventBtn : ImageView = view.findViewById(R.id.eventosButton)
        var webBtn : ImageView = view.findViewById(R.id.webButton2)
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.caritas.org.mx"))

        infoBtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.feedFragment)
        }

        eventBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.eventsFragment)
        }

        webBtn.setOnClickListener{
            startActivity(browserIntent)
        }

    }
}