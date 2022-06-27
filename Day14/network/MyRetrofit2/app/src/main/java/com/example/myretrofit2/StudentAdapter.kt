package com.example.myretrofit2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myretrofit2.data.Student

class StudentAdapter(private var students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    fun updateList(list: MutableList<Student>) {
        students = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtId = view.findViewById<TextView>(R.id.txtId)
        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtRoll = view.findViewById<TextView>(R.id.txtRoll)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.student_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtId.text = students[position].id.toString()
        holder.txtName.text = students[position].name
        holder.txtRoll.text = students[position].rollNo
    }

    override fun getItemCount() = students.size
}