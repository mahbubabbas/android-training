package com.example.testworkmanager

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.lang.Thread.sleep

const val KEY_RESULT = "key_result"

class MyWorker(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        var result = 0
        for (i in 1..10) {
            sleep(1000L)
            result += (1..100).random()
        }

        if (result > 0) {
            val output: Data = workDataOf(KEY_RESULT to result)
            return Result.success(output)
        }

        return Result.failure()
    }

    override fun onStopped() {
        println("stopped...")
        super.onStopped()
    }
}