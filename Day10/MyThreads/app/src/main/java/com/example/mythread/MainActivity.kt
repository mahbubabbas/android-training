package com.example.mythread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)

        btn.setOnClickListener {
            val t = MyThread(this)
            t.start()

            val t2 = Thread(MyRunnableThread(this))
            t2.start()

            thread (start = true) {
                var i = 0
                val v = findViewById<TextView>(R.id.textView3)

                while (true) {
                    runOnUiThread{
                        v.text = "${i++}"
                    }
                    Thread.sleep(300)
                }
            }
        }
    }
}

