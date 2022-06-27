package com.example.coroutinetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("abcd... before coroutine")

        GlobalScope.launch {
            //delay(1000L)
            //println("abcd... inside coroutine")
            foo()
        }

        println("abcd... after coroutine")
    }

    suspend fun foo() {
        for(i in 1..5) {
            println("abcd... $i")
        }
    }

}


