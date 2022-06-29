package com.example.myunittestsampleapp

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ResourceHelperTest {
    lateinit var resourceHelper: ResourceHelper


    //Resource id string is NOT equal to given string
    @Test
    fun resIdNotEqualToString() {
        resourceHelper = ResourceHelper()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val res = resourceHelper.compareResourceString(context, R.string.test_id, "hello")

        assertThat(res).isFalse()
    }


    //Resource id string is equal to given string
    @Test
    fun resIdEqualToString() {
        resourceHelper = ResourceHelper()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val res = resourceHelper.compareResourceString(context, R.string.test_id, "Test")

        assertThat(res).isTrue()
    }

}