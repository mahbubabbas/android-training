package com.example.myapplication

class Dice {
    private val sides = 6

    fun roll(): List<Int> {
        return when ((1..sides).random()) {
            1 -> listOf(1, R.drawable.d1)
            2 -> listOf(2, R.drawable.d2)
            3 -> listOf(3, R.drawable.d3)
            4 -> listOf(4, R.drawable.d4)
            5 -> listOf(5, R.drawable.d5)
            else -> listOf(6, R.drawable.d6)
        }
    }
}
