package com.example.myretrofit2.data

import com.google.gson.annotations.SerializedName

data class Student(
    val id: Int,
    val name: String,
    @SerializedName(value = "roll_no")
    val rollNo: String
)
