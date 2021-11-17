package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main_menu.perfilButton
import kotlinx.android.synthetic.main.fragment_main_menu.infoButton
import kotlinx.android.synthetic.main.fragment_main_menu.donacionesButton

class MainMenu : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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

        perfilButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.perfilFragment)
        }

        infoButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.feedFragment)
        }

        donacionesButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.donacionesCaritas)
        }

    }

}