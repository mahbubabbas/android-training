package com.example.mysqldb

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysqldb.student.Student
import com.example.mysqldb.student.StudentModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    private val db = StudentModel(this)

    var students = ArrayList<Student>()
    lateinit var studentListAdapter: StudentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentRecycler = findViewById<RecyclerView>(R.id.listStudent)
        studentRecycler.layoutManager = LinearLayoutManager(this)

        students = db.readAll()
        studentListAdapter = StudentListAdapter(students)
        studentRecycler.adapter = studentListAdapter

        val btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            showDialog()
        }
    }

    fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Add Student")

        val view = layoutInflater.inflate(R.layout.edit_dialog, null)
        dialogBuilder.setView(view)

        val txtId = view.findViewById<EditText>(R.id.txtId)
        val txtName = view.findViewById<EditText>(R.id.txtName)
        val txtRoll = view.findViewById<EditText>(R.id.txtRoll)

        dialogBuilder.setNeutralButton("Save") { dialog, which ->
            db.create(
                Student(
                    id = Integer.valueOf(txtId.text.toString()),
                    name = txtName.text.toString(),
                    rollNo = Integer.valueOf(txtRoll.text.toString())
                )
            )
        }

        dialogBuilder.setOnDismissListener {
            val i = Intent(this@MainActivity, MainActivity::class.java)
            finish()
            overridePendingTransition(0, 0)
            startActivity(i)
            overridePendingTransition(0, 0)
        }

        dialogBuilder.show()
    }
}
