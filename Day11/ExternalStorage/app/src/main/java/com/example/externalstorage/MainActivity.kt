package com.example.externalstorage

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Environment.MEDIA_MOUNTED
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    lateinit var myTxt: TextView
    lateinit var btnWrite: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTxt = findViewById(R.id.myTxt)
        btnWrite = findViewById(R.id.btnWrite)

        //checkStorageState()

        val downloadFolder =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val file = File(downloadFolder, "abbas.txt")

        //checkStorageState()

        btnWrite.setOnClickListener {
            /*if (writeFile(file, "<h1>this is a test</h1><h1>this is a test</h1>")) {
                Toast.makeText(this, "File write successful", Toast.LENGTH_LONG).show()
            }*/
            ActivityCompat.requestPermissions(
                this,
                arrayOf(READ_EXTERNAL_STORAGE),
                23
            )

            //writeFile(file, "this is a test")

            val s = readFile(file)
            myTxt.text = s?.let { it1 -> String(it1) }
        }
    }

    fun checkStorageState(): Boolean {
        val state = Environment.getExternalStorageState()

        var permission = false

        if (state == MEDIA_MOUNTED) {
            Toast.makeText(this, "Storage is accessible", Toast.LENGTH_LONG).show()
            permission = true
        } else {
            Toast.makeText(this, "Storage is NOT accessible", Toast.LENGTH_LONG).show()
            permission = false
        }

        if (permission) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
                23
            )
        }

        return permission
    }

    fun writeFile(file: File, text: String): Boolean {
        try {
            val fileOutput = FileOutputStream(file)
            fileOutput.write(text.toByteArray())
            return true
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        } finally {
            try {
                (null as FileOutputStream?)?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun readFile(file: File): ByteArray? {
        try {
            val fileInput = FileInputStream(file)
            val s = fileInput.readBytes()
            fileInput.close()
            return s
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

}