package com.example.mydagger2.data

import javax.inject.Inject

class Car @Inject constructor(private val wheels: Wheels, private val engine: Engine) {
    fun start() {
        println("car is running...with ${wheels.brand} wheel and ${engine.type} engine")
    }
}