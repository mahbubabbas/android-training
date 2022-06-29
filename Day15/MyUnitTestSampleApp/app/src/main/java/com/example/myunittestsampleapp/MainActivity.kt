package com.example.myunittestsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var resourceHelper: ResourceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resourceHelper = ResourceHelper()
        val x = resourceHelper.compareResourceString(this, R.string.test_id, "Test")
        println("our android test...$x")
    }
}
