package com.example.cellularsystems_lectures

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class addStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val saveButton : Button = findViewById(R.id.add_student_activity_save_button)
        val cancelButton : Button = findViewById(R.id.add_student_activity_cancel_button)

        val nameEditTextv: EditText = findViewById(R.id.add_student_activity_name_edit_text)
        val idEditText: EditText = findViewById(R.id.add_student_activity_id_edit_text)

        val saveMassageEditView: TextView = findViewById(R.id.add_student_activity_save_button)

        cancelButton.setOnClickListener{
            saveMassageEditView.text = "Name:${nameEditTextv.text} ID: ${idEditText.text} is saved!"
        }
    }
}