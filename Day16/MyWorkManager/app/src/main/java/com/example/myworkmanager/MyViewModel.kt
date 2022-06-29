package com.example.myworkmanager

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.work.*
import java.time.Duration
import java.util.concurrent.TimeUnit

const val ABBAS_DATA_TAG: String = "abbas_data_tag"

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val workManager = WorkManager.getInstance(application)

    private val workRequest =
        PeriodicWorkRequest.Builder(RandomNumGenerator::class.java, 15, TimeUnit.MINUTES)
            .addTag(ABBAS_DATA_TAG)
            .build()

    val workData: LiveData<List<WorkInfo>> = workManager.getWorkInfosByTagLiveData(ABBAS_DATA_TAG)

    fun startWork() {
        println("abbas: work started...")
        workManager.enqueue(workRequest)
    }

    fun stopWork() {
        workManager.cancelWorkById(workRequest.id)
        println("abbas: work stopped...")
    }

}