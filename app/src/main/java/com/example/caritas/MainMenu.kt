package com.example.caritas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.*

class MainMenu : Fragment() {

    private lateinit var infoBtn: ImageButton
    private lateinit var donarBtn: ImageButton
    private lateinit var perfilBtn: ImageButton
    private lateinit var historialBtn: ImageButton
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
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        infoBtn = view.findViewById(R.id.infoButton)
        donarBtn = view.findViewById(R.id.donarButton)
        perfilBtn = view.findViewById(R.id.perfilButton)
        historialBtn = view.findViewById(R.id.historialButton)
        eventosBtn = view.findViewById(R.id.eventosButton)


        infoBtn.setOnClickListener{
            fragManager.commit{
                replace<FeedFragment>(R.id.fragmentCont)
            }
        }

        perfilBtn.setOnClickListener{
            fragManager.commit{
                replace<PerfilFragment>(R.id.fragmentCont)
            }
        }

        historialBtn.setOnClickListener{
            fragManager.commit{
                replace<DonacionesCaritas>(R.id.fragmentCont)
            }
        }

        eventosBtn.setOnClickListener{
            fragManager.commit{
                replace<EventsFragment>(R.id.fragmentCont)
            }
        }



    }


    }