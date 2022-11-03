/**
 * Author - Michael Mathew Setiadi / 2072007
 */
package com.michael.kotlinq1

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.michael.kotlinq1.databinding.ActivityScrollingBinding
import com.michael.kotlinq1.entity.Data

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
        val data = intent.getParcelableExtra<Data>("data")
        if(data != null) {
            binding.toolbarLayout.title = data.id
            binding.contentScrolling.tvName?.text = data.name
            binding.contentScrolling.tvAge?.text = data.age
            binding.contentScrolling.tvAddress?.text = data.address
            binding.contentScrolling.tvPhone?.text = data.phone
            binding.contentScrolling.tvCompany?.text = data.company
            binding.contentScrolling.tvEmail?.text = data.email
            binding.contentScrolling.tvFriend?.text = data.friends.toString()
            binding.contentScrolling.tvTag?.text = data.tags.toString()
        }
    }
}