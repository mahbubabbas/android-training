package com.example.myretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit2.data.Student
import com.example.myretrofit2.viewmodel.StudentViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        studentViewModel.getBusyStatus().observe(this) {
            when (it) {
                true -> progressBar.visibility = VISIBLE
                else -> progressBar.visibility = GONE
            }
        }

        studentViewModel.getStudents().observe(this) {
            it?.let {
                students = it
                studentAdapter.updateList(it as MutableList<Student>)
            }
        }

        studentViewModel.callGetStudentApi()


        findViewById<FloatingActionButton>(R.id.btnAdd).setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog, null)
        dialog.setView(dialogView)
        dialog.setTitle("Add Student")

        val txtId = dialogView.findViewById<EditText>(R.id.txtId)
        val txtName = dialogView.findViewById<EditText>(R.id.txtName)
        val txtRoll = dialogView.findViewById<EditText>(R.id.txtRoll)

        dialog.setPositiveButton("Save") { dialog, which ->
            studentViewModel.callAddStudentApi(
                Student(
                    id = 1, //dummy
                    name = txtName.text.toString(),
                    rollNo = txtRoll.text.toString(),
                )
            )
        }

        dialog.create()
        dialog.show()
    }
}

