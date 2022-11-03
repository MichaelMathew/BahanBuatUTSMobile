/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.michael.assignment06_2072007.adapter.FoodAdapter
import com.michael.assignment06_2072007.databinding.ActivityMainBinding
import com.michael.assignment06_2072007.entity.Food
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var foods: ArrayList<Food>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        foods = ArrayList()
        foodAdapter = FoodAdapter(foods)
        val manager = LinearLayoutManager(this@MainActivity)
        binding.rvFood.adapter = foodAdapter
        binding.rvFood.layoutManager = manager

        foodAdapter.setFoodListener(object : FoodAdapter.FoodListener {
            override fun foodClicked(foods: Food) {
                val intent = Intent(this@MainActivity,ScrollingActivity::class.java)
                intent.putExtra("food",foods)
                startActivity(intent)
            }

        })
    }

    override fun onStart() {
        super.onStart()
        dataFood()
    }

    override fun onResume() {
        super.onResume()
        val food = intent.getParcelableExtra<Food>("food")
        if (food != null) {
            foods.add(food)
            foodAdapter.notifyItemChanged(0)
        }
    }

    private fun dataFood(){
        val inputStream = assets.open("food.json")
        val reader = JsonReader(InputStreamReader(inputStream, "UTF-8"))
        val gson = Gson()
        val data = gson.fromJson<Array<Food>>(reader, Array<Food>::class.java)
        foods.clear()
        foods.addAll(data)
        foodAdapter.notifyItemChanged(0)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val secondIntent = Intent(this@MainActivity,AddDataActivity::class.java)
        when(item.itemId) {
            R.id.addicon -> {
                secondIntent.putExtra("foods",foods)
                startActivity(secondIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}