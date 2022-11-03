package com.michael.assignment05_2072007

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.michael.assignment05_2072007.databinding.ActivitySecondBinding
import com.michael.assignment05_2072007.entity.Student

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrStudent = arrayListOf<Student>()
        val Students = intent.getParcelableArrayListExtra<Student>("list")

        Students?.forEach { s: Student? ->
            if (s != null) {
                arrStudent.add(s)
            }
        }
        val studentAdapter = ArrayAdapter(
            this@SecondActivity,
            R.layout.simple_list_item_1,
            arrStudent
        )
        binding.listView.adapter = studentAdapter
    }
}