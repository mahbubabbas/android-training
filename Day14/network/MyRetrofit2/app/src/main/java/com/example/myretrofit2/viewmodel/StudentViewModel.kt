package com.example.myretrofit2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit2.data.Student
import com.example.myretrofit2.network.StudentApi
import com.example.myretrofit2.network.StudentFactory
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    private val studentApi: StudentApi = StudentFactory
        .getInstance()
        .create(StudentApi::class.java)

    private val _liveStudens = MutableLiveData<List<Student>>()

    fun getStudents() = _liveStudens

    fun callGetStudentApi() {
        viewModelScope.launch {
            try {
                val students = studentApi.getStudents()
                _liveStudens.postValue(students)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

