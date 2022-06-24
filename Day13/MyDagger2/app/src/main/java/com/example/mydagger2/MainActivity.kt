package com.example.mydagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydagger2.data.Car
import com.example.mydagger2.data.DaggerCarComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var car : Car
    @Inject
    lateinit var car2 : Car
    @Inject
    lateinit var car3 : Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerCarComponent.create()
        component.inject(this)

        car.start()
        car2.start()
        car3.start()
    }
}

