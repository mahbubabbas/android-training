package com.example.mytoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var li = LayoutInflater.from(this)
        var layout = li.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast))

        var t = Toast(applicationContext)
        t.duration = Toast.LENGTH_LONG
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        t.setView(layout)


        btn = findViewById(R.id.myButton)
        btn.setOnClickListener() {
            //Toast.makeText(this, "This is a test", Toast.LENGTH_LONG).show()
            t.show()
        }
    }
}
