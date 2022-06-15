package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var txtLoginHeader: TextView
    lateinit var edtUsername : EditText
    lateinit var edtPassword : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        txtLoginHeader = findViewById(R.id.textLoginHeader)

        edtUsername = findViewById(R.id.username)
        edtPassword = findViewById(R.id.password)

        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString()
            val pass = edtPassword.text.toString()

            if (username == "Abcd" && pass == "pass") {
                //Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                val i = Intent(this, HomeActivity::class.java).apply {
                    putExtra(MY_MESSAGE, username)
                }
                startActivity(i)
            } else {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

