package com.example.mynotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AlertActivity : AppCompatActivity() {
    lateinit var txtTitle : TextView
    lateinit var txtContent : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val title = intent.getStringExtra(NOTIFICATION_TITLE)
        val content = intent.getStringExtra(NOTIFICATION_CONTENT)

        txtTitle = findViewById(R.id.textTitle)
        txtContent = findViewById(R.id.textContent)

        txtTitle.text = "Title"
        txtContent.text = "This dskdf sdfksdfkd fdkfksdf sdfksdfksdf sdfksdkfs dfsdkfksdf sdfksdfksdkfsd fsdkfsdkfksdfksdf"
    }
}