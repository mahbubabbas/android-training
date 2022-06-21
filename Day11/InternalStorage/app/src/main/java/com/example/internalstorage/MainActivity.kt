package com.example.internalstorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var tvFileContent: TextView
    lateinit var btnAction: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFileContent = findViewById(R.id.tvFileContent)
        btnAction = findViewById(R.id.btnAction)

        btnAction.setOnClickListener {
            //writeFile("abcd.txt", "this is my file content blah blah blah...")
            //val content = readFile("abcd.txt")?.let { it1 -> String(it1) }
            val content = readFileEx("abcd.txt")
            tvFileContent.text = content
        }
    }

    fun writeFile(filePath: String, content: String) {
        var fos: FileOutputStream? = null
        try {
            fos = openFileOutput(filePath, Context.MODE_PRIVATE)
            fos?.write(content.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
    }

    fun readFile(filePath: String): ByteArray? {
        var fis: FileInputStream? = null
        try {
            fis = openFileInput(filePath)
            return fis?.readBytes()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            fis?.close()
        }
    }

    fun readFileEx(filePath: String): String? {
        var fis: FileInputStream? = null
        try {
            fis = openFileInput(filePath)
            val isr = InputStreamReader(fis)
            val buffReader = BufferedReader(isr)

            val sb = StringBuilder()
            var text: String? = null
            while ({ text = buffReader.readLine(); text }() != null) {
                sb.append(text)
            }
            return sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } finally {
            fis?.close()
        }
    }
}