package com.example.myworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.myworkmanager.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        binding.activity = this

        viewModel = MyViewModel(application)

        viewModel.workData.observe(this) {
            it?.let {
                if (it.isNotEmpty() && it[0].state.isFinished) {
                    println("kaka...${it[0].outputData.getInt(ABBAS_DATA_TAG, 0)}")
                }
            }
        }
    }

    fun onWorkStart() {
        viewModel.startWork()
        println("abbas: work started...")
    }

    fun onWorkStop() {
        viewModel.stopWork()
        println("abbas: work stopped...")
    }
}