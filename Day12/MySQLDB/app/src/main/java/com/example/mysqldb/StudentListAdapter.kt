package com.example.mysqldb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysqldb.student.Student

class StudentListAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = LayoutInflater.from(parent.context)
        val listItem = li.inflate(R.layout.row_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.textId.text = student.id.toString()
        holder.textName.text = student.name
        holder.textRoll.text = student.rollNo.toString()
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textId: TextView = itemView.findViewById(R.id.txtId)
        val textName: TextView = itemView.findViewById(R.id.txtName)
        val textRoll: TextView = itemView.findViewById(R.id.txtRoll)
    }
}