package com.example.myviewmodel

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var count = 0

    fun increment() {
        count++
    }
}
