package com.example.mysqldb.student

import android.content.ContentValues
import android.content.Context

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class StudentModel(context: Context) : SQLiteOpenHelper(
    context,
    STUDENT_DB,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(QueryString.CREATE_STUDENT_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(QueryString.DROP_STUDENT_TABLE)
        onCreate(db)
    }

    fun create(student: Student) {
        val studVal = ContentValues()

        studVal.put(TableColumn.ID, student.id)
        studVal.put(TableColumn.NAME, student.name)
        studVal.put(TableColumn.ROLL_NO, student.rollNo)

        writableDatabase.insert(STUDENT_TABLE, null, studVal)
        writableDatabase.close()
    }

    fun readAll(): ArrayList<Student> {
        val students = ArrayList<Student>()
        val cursor = readableDatabase.rawQuery(QueryString.SELECT_ALL_STUDENTS, null)

        while (cursor.moveToNext()) {
            students.add(
                Student(
                    id = cursor.getInt(0),
                    name = cursor.getString(1),
                    rollNo = cursor.getInt(2),
                )
            )
        }

        cursor.close()
        readableDatabase.close()

        return students
    }

    fun read(id: Int): Student {
        val student: Student?
        val cursor = readableDatabase.rawQuery(QueryString.SELECT_STUDENT, arrayOf(id.toString()))
        cursor.moveToFirst()

        student = Student(
            id = cursor.getInt(0),
            name = cursor.getString(1),
            rollNo = cursor.getInt(2),
        )

        cursor.close()
        readableDatabase.close()

        return student
    }

    fun delete(id: Int) {
        writableDatabase.delete(
            STUDENT_TABLE,
            TableColumn.ID + "=?",
            arrayOf(id.toString())
        )

        writableDatabase.close()
    }

    fun deleteAll() {
        writableDatabase.delete(STUDENT_TABLE, null, null)
        writableDatabase.close()
    }

}