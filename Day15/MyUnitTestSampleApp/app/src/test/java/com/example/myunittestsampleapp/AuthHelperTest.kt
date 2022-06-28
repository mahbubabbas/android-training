package com.example.myunittestsampleapp

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AuthHelperTest {

    ///Login validation
    //1. Empty username should return false
    //2. Empty password should return false
    //3. Non empty username and password should return true
    @Test
    fun `empty username returns false`() {
        val result = AuthHelper.validateLogin("", "1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`() {
        val result = AuthHelper.validateLogin("abcd", "")
        assertThat(result).isFalse()
    }

    @Test
    fun `non empty username and password return true`() {
        val result = AuthHelper.validateLogin("abcd", "ksdfk")
        assertThat(result).isTrue()
    }
}