package com.example.myretrofit2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myretrofit2.data.Student
import com.example.myretrofit2.network.StudentApi
import com.example.myretrofit2.network.StudentFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StudentViewModel : ViewModel() {
    private val studentApi: StudentApi = StudentFactory
        .getInstance()
        .create(StudentApi::class.java)

    private val _liveStudents = MutableLiveData<List<Student>>()
    private val _busy = MutableLiveData<Boolean>()

    private suspend fun fetchAllStudents() {
        delay(3000L)
        val students = studentApi.getStudents()
        _liveStudents.postValue(students)
    }

    fun getStudents() = _liveStudents
    fun getBusyStatus() = _busy

    fun callGetStudentApi() {
        _busy.postValue(true)
        viewModelScope.launch {
            try {
                fetchAllStudents()
                _busy.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
                _busy.postValue(false)
            }
        }
    }

    fun callAddStudentApi(student: Student) {
        _busy.postValue(true)
        viewModelScope.launch {
            try {
                studentApi.createStudent(
                    name = student.name,
                    rollNo = student.rollNo
                )

                fetchAllStudents()
                _busy.postValue(false)
            } catch (e: Exception) {
                e.printStackTrace()
                _busy.postValue(false)
            }
        }
    }

}

