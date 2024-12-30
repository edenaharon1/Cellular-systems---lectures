package com.example.cellularsystems_lectures

import android.widget.TextView
import android.widget.CheckBox
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.cellularsystems_lectures.model.Model
import com.example.cellularsystems_lectures.model.Student
import android.util.Log




class StudentListViewActivity : AppCompatActivity() {

    val students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_student_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Student_List_View)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //TODO 1: set xml layout
        //TODO 2: creat instance of the list view
        //TODO 3: create an adapter
        //TODO 4: create rows layout
        //TODO 5: set dynamic data
        //TODO 6: set on click on checkbox

        val students = Model.shared.students

        val listView: ListView? = findViewById<ListView>(R.id.Student_List_View)
        listView?.adapter = StudentsAdapter()

    }

    inner class StudentsAdapter : BaseAdapter() {
        override fun getCount(): Int = students?.size ?: 0


        override fun getItem(position: Int): Any {
            return 0
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val inflator = LayoutInflater.from(parent?.context)

            val student = students?.get(position)

            var view = convertView
            if (view == null) {
                view = inflator.inflate(R.layout.student_list_row, parent, false)
                Log.d("TAG", "Inflating position $position")
                val checkbox: CheckBox? = view?.findViewById(R.id.student_activity_chackbox)
              //  checkbox?.setOnCheckedChangeListener { _, isChecked ->
               //     student?.isChecked = isChecked
               // }
                checkbox?.apply {
                    setOnClickListener { view ->
                        (tag as? Int)?.let { tag ->
                            val student = students?.get(tag)
                            student?.isChecked = (view as? CheckBox)?.isChecked ?: false
                        }
                    }
                }

            }




            val nametextview: TextView? = view?.findViewById(R.id.student_row_name_text_view)
            val idtextview: TextView? = view?.findViewById(R.id.student_row_id_text_view)
            val checkbox: CheckBox? = view?.findViewById(R.id.student_activity_chackbox)

            checkbox?.apply {
                isChecked = student?.isChecked ?: false
                tag = position
            }
            nametextview?.text = student?.name ?: "Unknown"
            idtextview?.text = student?.id ?: "N/A"

            return view!!
        }

    }

}