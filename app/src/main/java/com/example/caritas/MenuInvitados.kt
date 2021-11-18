package com.example.caritas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [menu_invitados.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuInvitados : Fragment() {

    private lateinit var infoBtn: ImageButton
    private lateinit var eventosBtn: ImageButton
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
        return inflater.inflate(R.layout.fragment_menu_invitados, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoBtn = view.findViewById(R.id.infoButton)
        eventosBtn = view.findViewById(R.id.eventosButton)


        infoBtn.setOnClickListener{
            fragManager.commit{
                replace<FeedFragment>(R.id.fragmentCont)
            }
        }

        eventosBtn.setOnClickListener{
            fragManager.commit{
                replace<EventsFragment>(R.id.fragmentCont)
            }
        }



    }

}