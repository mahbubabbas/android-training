package com.example.myretrofit2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StudentFactory {
    private const val BASE_URL = "http://192.168.0.163/"

    fun getInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

