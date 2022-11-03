/**
 * Author - Michael Mathew Setiadi / 2072007
 */

package com.michael.assignment06_2072007.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.michael.assignment06_2072007.R
import com.michael.assignment06_2072007.databinding.FoodBinding
import com.michael.assignment06_2072007.entity.Food

class FoodAdapter(private val foods: ArrayList<Food>) : Adapter<FoodAdapter.FoodHolder>() {
    private lateinit var foodListener: FoodListener
    inner class FoodHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: FoodBinding
        init {
            binding = FoodBinding.bind(itemView)
        }

        fun setMenuData(food:Food){
            binding.tvId.text = food.id
            binding.tvName.text = food.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food,parent,false)
        return FoodHolder(view)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.setMenuData(foods[position])
        holder.itemView.setOnClickListener {
            foodListener.foodClicked(foods[position])
        }
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun setFoodListener(foodListener: FoodListener) {
        this.foodListener = foodListener
    }

    interface FoodListener {
        fun foodClicked(foods: Food)
    }


}