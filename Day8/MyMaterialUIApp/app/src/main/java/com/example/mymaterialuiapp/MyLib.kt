package com.example.mymaterialuiapp

class MyLib {
    @MyAnnotation("Kotlin") val myVal : String = ""
}

annotation class MyAnnotation(val s: String)
