package com.example.myretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit2.data.Student
import com.example.myretrofit2.viewmodel.StudentViewModel

class MainActivity : AppCompatActivity() {
    private val studentViewModel: StudentViewModel by viewModels()
    var students: List<Student> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //studentViewModel.callGetStudentApi()
        val rvStudent = findViewById<RecyclerView>(R.id.rvStudents)
        rvStudent.layoutManager = LinearLayoutManager(this)
        val studentAdapter = StudentAdapter(students)
        rvStudent.adapter = studentAdapter

        studentViewModel.getStudents().observe(this) {
            it?.let {
                students = it
                studentAdapter.updateList(it as MutableList<Student>)
            }
        }

        studentViewModel.callGetStudentApi()
    }
}

