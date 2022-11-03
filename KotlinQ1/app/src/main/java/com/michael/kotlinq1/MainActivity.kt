/**
 * Author - Michael Mathew Setiadi / 2072007
 */
package com.michael.kotlinq1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.michael.kotlinq1.adapter.DataAdapter
import com.michael.kotlinq1.databinding.ActivityMainBinding
import com.michael.kotlinq1.entity.Data
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dataAdapter: DataAdapter
    private lateinit var datas: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datas = ArrayList()
        dataAdapter = DataAdapter(datas)
        val manager = LinearLayoutManager(this@MainActivity)
        binding.rvData.adapter = dataAdapter
        binding.rvData.layoutManager = manager

        dataAdapter.setDataListener(object : DataAdapter.DataListener {
            override fun dataClicked(datas: Data) {
                val intent = Intent(this@MainActivity,ScrollingActivity::class.java)
                intent.putExtra("data",datas)
                startActivity(intent)
            }
        })

    }

    override fun onStart() {
        super.onStart()
        data()
        val name = intent.getStringExtra(Intent.EXTRA_TEXT)
        AlertDialog.Builder(this@MainActivity).setMessage("Welcome $name").show()
    }

    private fun data(){
        val inputStream = assets.open("data.json")
        val reader = JsonReader(InputStreamReader(inputStream, "UTF-8"))
        val gson = Gson()
        val data = gson.fromJson<Array<Data>>(reader, Array<Data>::class.java)
        datas.clear()
        datas.addAll(data)
        dataAdapter.notifyItemChanged(0)
    }
}