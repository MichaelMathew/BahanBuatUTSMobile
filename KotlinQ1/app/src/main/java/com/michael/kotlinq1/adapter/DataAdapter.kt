/**
 * Author - Michael Mathew Setiadi / 2072007
 */
package com.michael.kotlinq1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michael.kotlinq1.R
import com.michael.kotlinq1.databinding.DataBinding
import com.michael.kotlinq1.entity.Data

class DataAdapter(private val datas: ArrayList<Data>) : RecyclerView.Adapter<DataAdapter.DataHolder>() {
    private lateinit var dataListener: DataListener
    inner class DataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: DataBinding
        init {
            binding = DataBinding.bind(itemView)
        }

        fun setData(Data:Data){
            binding.tvId.text = Data.id
            binding.tvName.text = Data.name
            binding.tvCompany.text = Data.company
            binding.tvEmail.text = Data.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.data,parent,false)
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.setData(datas[position])
        holder.itemView.setOnClickListener {
            dataListener.dataClicked(datas[position])
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun setDataListener(dataListener: DataListener) {
        this.dataListener = dataListener
    }

    interface DataListener {
        fun dataClicked(datas: Data)
    }


}