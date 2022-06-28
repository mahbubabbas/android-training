package com.example.myunittestsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.sql.RowId

class MainActivity : AppCompatActivity() {
    val resourceHelper = ResourceHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resourceHelper.compareResourceString(this, R.string.app_name, "My UnitTest Sample App")
    }
}