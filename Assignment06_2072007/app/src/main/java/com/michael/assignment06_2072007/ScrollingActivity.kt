/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.michael.assignment06_2072007.databinding.ActivityScrollingBinding
import com.michael.assignment06_2072007.entity.Food

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
    }

    override fun onStart() {
        super.onStart()
        val food = intent.getParcelableExtra<Food>("food")
        if(food != null) {
            binding.toolbarLayout.title = food.id
            binding.contentScrolling.tvName?.text = food.name
            binding.contentScrolling.tvPrice?.text = food.price.toString()
            binding.contentScrolling.tvRating?.text = food.rating.toString()
            binding.contentScrolling.tvTgl?.text = food.date
            binding.contentScrolling.tvCategory?.text = food.category.toString()
        }
    }
}