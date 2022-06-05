package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var rollButton: Button
    lateinit var dice: Dice
    lateinit var rollView : TextView
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice = Dice()
        rollButton = findViewById(R.id.rollButton)
        rollView = findViewById(R.id.rollView)
        diceImage = findViewById(R.id.diceImg)

        rollButton.setOnClickListener() {
            val d = dice.roll()
            rollView.setText(d[0].toString())
            diceImage.setImageResource(d[1])
        }
    }
}
