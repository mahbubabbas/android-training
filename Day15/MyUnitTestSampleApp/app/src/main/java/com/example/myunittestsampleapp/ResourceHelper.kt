package com.example.myunittestsampleapp
import android.content.Context

class ResourceHelper {
    fun compareResourceString(context: Context, resId: Int, resString: String): Boolean {
        return context.getString(resId) == resString
    }
}