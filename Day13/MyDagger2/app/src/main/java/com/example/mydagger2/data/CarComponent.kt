package com.example.mydagger2.data

import com.example.mydagger2.MainActivity
import dagger.Component

@Component
interface CarComponent {
    fun getCar(): Car

    fun inject(mainActivity: MainActivity)
}
