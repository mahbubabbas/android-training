package com.example.mythread

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyThread (private val activity: AppCompatActivity): Thread() {
    override fun run() {
        super.run()
        var i = 0
        val v = activity.findViewById<TextView>(R.id.textView)

        while (true) {
            activity.runOnUiThread{
                v.text = "${i++}"
            }

            Thread.sleep(100)
        }
    }
}

class MyRunnableThread(private val activity: AppCompatActivity) : Runnable {
    override fun run() {
        var i = 0
        val v = activity.findViewById<TextView>(R.id.textView2)

        while (true) {
            activity.runOnUiThread{
                v.text = "${i++}"
            }

            Thread.sleep(200)
        }
    }
}

