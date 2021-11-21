package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation

class MainMenu : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var perfilBtn : ImageView = view.findViewById(R.id.perfilButton)
        var infoBtn : ImageView = view.findViewById(R.id.infoButton)
        var donacionesBtn : ImageView = view.findViewById(R.id.donacionesButton)

        perfilBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.perfilFragment)
        }

        infoBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.feedFragment)
        }

        donacionesBtn.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.donacionesCaritas)
        }

    }

}