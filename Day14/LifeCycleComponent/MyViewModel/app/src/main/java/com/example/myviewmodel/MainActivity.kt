package com.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    var count = 0
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInc = findViewById<Button>(R.id.btnInc)
        val txtCount = findViewById<TextView>(R.id.txtCount)

        txtCount.text = myViewModel.count.toString()

        btnInc.setOnClickListener {
            myViewModel.increment()
            txtCount.text = myViewModel.count.toString()
        }
    }
}
