/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.michael.assignment06_2072007.adapter.FoodAdapter
import com.michael.assignment06_2072007.databinding.ActivityAddDataBinding
import com.michael.assignment06_2072007.entity.Category
import com.michael.assignment06_2072007.entity.Food
import java.util.Calendar

class AddDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddDataBinding
    private lateinit var foods: ArrayList<Food>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddDataBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val calendar = Calendar.getInstance()
        binding.btnDate.setOnClickListener {
            DatePickerDialog(
                this@AddDataActivity,
                {datePicker, i, i2, i3 ->
                    calendar.set(Calendar.YEAR,i)
                    calendar.set(Calendar.MONTH,i2)
                    calendar.set(Calendar.DATE,i3)
                    Toast.makeText(this@AddDataActivity, calendar.time.toString(),
                        Toast.LENGTH_SHORT).show()
                    binding.date.text = "${i3.toString()}/${(i2+1).toString()}/${i.toString()}"
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DATE],
            ).show()

        }
        val category = ArrayList<Category>()
        category.add(Category("Makanan Ringan"))
        category.add(Category("Makanan Berat"))
        category.add(Category("Snack"))
        val categoryAdapter = ArrayAdapter(
            this@AddDataActivity,
            android.R.layout.simple_spinner_dropdown_item,
            category
        )
        binding.spCategory.adapter = categoryAdapter

        binding.btnAdd.setOnClickListener {
            val intent = Intent(this@AddDataActivity,MainActivity::class.java)
            val id = binding.etId.text.toString()
            val name = binding.etName.text.toString()
            val price = binding.etPrice.text.toString().toInt()
            val rating = binding.etRating.text.toString().toFloat()
            val date = binding.date.text.toString()
            val category = binding.spCategory.selectedItem as Category
            val food = Food(id,name,price,rating,date,category)

            foods.forEach { food ->
                if (food.id == id) {
                    Toast.makeText(this@AddDataActivity, "Id Yang Dimasukkan Tidak Boleh Sama Dengan Yang Sudah Ada", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            foods.add(food)
            intent.putExtra("food",food)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        foods = intent.getParcelableArrayListExtra<Food>("foods") as ArrayList<Food>
    }
}