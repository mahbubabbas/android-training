package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    lateinit var txtHello : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        txtHello = findViewById(R.id.txtHello)

        val username = intent.getStringExtra(MY_MESSAGE)
        txtHello.text = "Hi $username"
    }
}