package com.example.testworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.time.Duration

class MainActivity : AppCompatActivity() {
    lateinit var workRequest: WorkRequest
    lateinit var workManager: WorkManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workRequest = OneTimeWorkRequestBuilder<MyWorker>()
            .build()

//        workRequest = PeriodicWorkRequestBuilder<MyWorker>(Duration.ofMinutes(15))
//            .build()

        workManager = WorkManager.getInstance(this)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        workManager.getWorkInfoByIdLiveData(workRequest.id).observe(this) {
            it?.let {
                val result = it.outputData.getInt(KEY_RESULT, 0)
                txtResult.text = "$result"
            }
        }

        btnStart.setOnClickListener {
            workManager.enqueue(workRequest)
        }

        val btnStop = findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener {
            workManager.cancelAllWork()
        }

    }

}