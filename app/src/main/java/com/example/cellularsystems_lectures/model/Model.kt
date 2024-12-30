package com.example.cellularsystems_lectures.model


class Model private constructor() {
    var students = mutableListOf<Student>() // רשימה ריקה של אובייקטים מסוג Student
    companion object {
        val shared = Model()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Student $i",
                id = "Student ID: $i",
                avatarUrl = "",
                isChecked = false

            )
            students.add(student)
        }
    }
}
