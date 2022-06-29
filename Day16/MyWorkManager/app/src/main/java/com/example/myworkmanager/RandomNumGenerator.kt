package com.example.myworkmanager

import android.content.Context
import androidx.work.*
import java.lang.Thread.sleep

class RandomNumGenerator(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    private var total = 0

    fun start(): Int {
        for (i in 1..10) {
            try {
                sleep(500)
                total += (0..100).random()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return total
    }

    override fun doWork(): Result {
        val x = start()
        return if (x > 0) {
            val data = workDataOf(ABBAS_DATA_TAG to x)
            Result.success(data)
        } else {
            return Result.failure()
        }
    }

    override fun onStopped() {
        super.onStopped()
        println("worker stopped....")
    }
}
