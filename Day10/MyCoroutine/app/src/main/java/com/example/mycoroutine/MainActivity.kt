package com.example.mycoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import kotlin.system.measureTimeMillis

const val apiKey = "945eed8b7ad84fb6bb1daa46fa86c34a"

class MainActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    val retrofit = Retrofit
        .Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
//            GlobalScope.launch {
//                val time = measureTimeMillis {
//                    val one = sampleOne()
//                    val two = sampleTwo()
//                    println("${one + two}")
//                }
//                println("Completed in $time")
//            }

            scope.launch {
                fetchTwoDocs()
            }

            println("EOF")
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }

    suspend fun fetchTwoDocs() =
        coroutineScope {
            val deferredOne = async { fetchDoc(1) }
            val deferredTwo = async { fetchDoc(2) }
            deferredOne.await()
            deferredTwo.await()
        }

    private suspend fun fetchDoc(i: Int) {
        val res = get("https://developer.android.com")
        println("$res: $i")
    }

    suspend fun get(url: String) = withContext(Dispatchers.IO) {
        return@withContext "this is a test"
    }

    suspend fun sampleOne(): Int {
        println("sampleOne:" + System.currentTimeMillis())
        delay(10L)
        return 10
    }

    suspend fun sampleTwo(): Int {
        println("sampleTwo:" + System.currentTimeMillis())
        delay(20L)
        return 20
    }

    fun getNews(date: String) {
        val url =
            "https://newsapi.org/v2/everything?q=apple&from=$date&to=$date&sortBy=popularity&apiKey=$apiKey"

    }
}

