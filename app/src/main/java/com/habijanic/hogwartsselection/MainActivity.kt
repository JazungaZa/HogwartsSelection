package com.habijanic.hogwartsselection

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var buttonName : Button
    lateinit var textName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttonName = findViewById(R.id.buttonAddName)
        textName = findViewById(R.id.textViewName)

        textName.isVisible=false

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val listFragment = ListFragment()

        fragmentTransaction.add(R.id.framaList,listFragment)
        fragmentTransaction.commit()

        buttonName.setOnClickListener {
            val secondfragmentManager : FragmentManager = supportFragmentManager
            val dialogFragment = DialogFragment()

            dialogFragment.isCancelable=false
            dialogFragment.show(secondfragmentManager, "DialogFragment")
        }

    }
    fun getUserData(userName : String){
        textName.text="" + userName
        textName.isVisible=true
    }


}