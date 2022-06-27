package com.example.myretrofit2.network

import com.example.myretrofit2.data.Student
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StudentApi {
    //Fetching students list
    @GET("students")
    suspend fun getStudents(): List<Student>

    //Creating a new student
    @FormUrlEncoded
    @POST("students")
    suspend fun createStudent(
        @Field("name") name: String,
        @Field("roll_no") rollNo: String
    )
}

