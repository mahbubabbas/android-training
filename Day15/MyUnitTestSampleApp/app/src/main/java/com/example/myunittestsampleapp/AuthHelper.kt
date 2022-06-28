package com.example.myunittestsampleapp

object AuthHelper {
    fun validateLogin(username: String, password: String): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            return false
        }

        return true
    }
}

