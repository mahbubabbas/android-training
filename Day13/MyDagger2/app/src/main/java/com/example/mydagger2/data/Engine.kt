package com.example.mydagger2.data

import javax.inject.Inject

//class Engine @Inject constructor() {
//    val type = "4 stroke"
//}

interface Engine {
    fun start() {
        println("engine started...")
    }
}
