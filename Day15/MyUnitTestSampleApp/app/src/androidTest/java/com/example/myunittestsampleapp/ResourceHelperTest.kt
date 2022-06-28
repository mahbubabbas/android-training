package com.example.myunittestsampleapp

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class ResourceHelperTest {
    private val resourceHelper = ResourceHelper()

    @Test
    fun resIdSameAsResString_returnsTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val res = resourceHelper.compareResourceString(
            context,
            R.string.app_name,
            "My UnitTest Sample App"
        )

        assertThat(res).isTrue()
    }

    @Test
    fun resIdDiffAsResString_returnsFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val res = resourceHelper.compareResourceString(
            context,
            R.string.app_name,
            "Hello"
        )

        assertThat(res).isFalse()
    }

}