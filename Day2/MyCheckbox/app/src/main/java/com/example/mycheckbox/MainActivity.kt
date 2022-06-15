package com.example.mycheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var chkItem1: CheckBox
    lateinit var chkItem2: CheckBox
    lateinit var chkItem3: CheckBox
    lateinit var chkCustom: CheckBox
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventListener()
    }

    private fun eventListener() {
        var totalAmount = 0

        chkItem1 = findViewById(R.id.chkItem1)
        chkItem2 = findViewById(R.id.chkItem2)
        chkItem3 = findViewById(R.id.chkItem3)
        chkCustom = findViewById(R.id.customChk)

        chkItem1.setOnClickListener() {
            if (chkItem1.isChecked) totalAmount += 100 else totalAmount -= 100
        }

        chkItem2.setOnClickListener() {
            if (chkItem2.isChecked) totalAmount += 200 else totalAmount -= 200
        }

        chkItem3.setOnClickListener() {
            if (chkItem3.isChecked) totalAmount += 50 else totalAmount -= 50
        }

        chkCustom.setOnClickListener() {
            if (chkCustom.isChecked) totalAmount += 70 else totalAmount -= 70
        }

        btn = findViewById(R.id.addBtn)

        btn.setOnClickListener() {
            findViewById<TextView>(R.id.totalText).setText("Total Amount: " + totalAmount)
        }
    }


}