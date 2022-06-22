package com.example.mysqldb.student

const val STUDENT_DB = "student_db"
const val DATABASE_VERSION = 1
const val STUDENT_TABLE = "students"

object TableColumn {
    const val ID = "id"
    const val NAME = "name"
    const val ROLL_NO = "roll_no"
}

object QueryString {
    const val CREATE_STUDENT_TABLE = "CREATE TABLE $STUDENT_TABLE(${TableColumn.ID} INTEGER PRIMARY KEY, " +
            "${TableColumn.NAME} TEXT, ${TableColumn.ROLL_NO} TEXT)"

    const val DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS $STUDENT_TABLE"

    const val SELECT_ALL_STUDENTS = "SELECT * FROM $STUDENT_TABLE"

    const val SELECT_STUDENT = "SELECT * FROM $STUDENT_TABLE WHERE ${TableColumn.ID} = ?"

    const val DELETE_ALL_STUDENTS = "DELETE FROM $STUDENT_TABLE"
}
