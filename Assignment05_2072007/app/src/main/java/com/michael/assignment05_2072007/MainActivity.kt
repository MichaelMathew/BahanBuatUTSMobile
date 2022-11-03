package com.michael.assignment05_2072007

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import com.michael.assignment05_2072007.databinding.ActivityMainBinding
import com.michael.assignment05_2072007.entity.Department
import com.michael.assignment05_2072007.entity.Student
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var Students: ArrayList<Student>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val departments = ArrayList<Department>()
        departments.add(Department("1","Teknologi Informasi"))
        departments.add(Department("2","Ekonomi"))
        departments.add(Department("3","Bahasa"))
        val departmentAdapter = ArrayAdapter(
            this@MainActivity,
            android.R.layout.simple_spinner_dropdown_item,
            departments
        )
        binding.spinnerDepartment.adapter = departmentAdapter
        val calendar = Calendar.getInstance()
        Students = ArrayList()
        binding.btnInput.setOnClickListener {
            var Jenis = ""
            if (binding.rbMale.isChecked){
                Jenis = "Male"
            } else {
                Jenis = "Female"
            }

            Students.add(Student(binding.txtId.text.toString(),binding.txtFirstname.text.toString()
                        ,binding.txtLastname.text.toString(),binding.txtAddress.text.toString(),
                         binding.txtPhone.text.toString(), Jenis,calendar.time,binding.spinnerDepartment.selectedItem as Department))
            binding.txtId.setText("")
            binding.txtFirstname.setText("")
            binding.txtLastname.setText("")
            binding.txtPhone.setText("")
            binding.txtAddress.setText("")
        }


        binding.btnDate.setOnClickListener {
            DatePickerDialog(
                this@MainActivity,
                {datePicker, i, i2, i3 ->
                    calendar.set(Calendar.YEAR, i)
                    calendar.set(Calendar.MONTH, i2)
                    calendar.set(Calendar.DATE, i3)
                    Toast.makeText(this@MainActivity, calendar.time.toString(),
                        Toast.LENGTH_SHORT).show()
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DATE],
            ).show()
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val secondIntent = Intent(this@MainActivity, SecondActivity::class.java)
        secondIntent.putExtra("list",Students)
        when (item.itemId) {
            R.id.nav_2ndpage -> startActivity(secondIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}