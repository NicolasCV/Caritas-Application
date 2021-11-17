package com.example.caritas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.prof.rssparser.Parser
import java.io.Serializable
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    private lateinit var returnBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        returnBtn = findViewById(R.id.returnButton)

        returnBtn.setOnClickListener{
            supportFragmentManager.commit{
                replace<MainMenu>(R.id.fragmentCont)
            }
        }

    }



}
