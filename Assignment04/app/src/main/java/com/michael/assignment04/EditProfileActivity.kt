package com.michael.assignment04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.assignment04.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSubmit.setOnClickListener {
            val Fname = binding.inputFName.text.toString()
            val Lname = binding.inputLName.text.toString()
            val Address = binding.inputAlamat.text.toString()
            val Email = binding.inputEmail.text.toString()
            val NRP = binding.inputNRP.text.toString()
            val intent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
            intent.putExtra("fname",Fname)
            intent.putExtra("lname", Lname)
            intent.putExtra("alamat", Address)
            intent.putExtra("email", Email)
            intent.putExtra("nrp",NRP)
            startActivity(intent)
            finishAffinity()
        }

    }

    override fun onStart() {
        super.onStart()
        val namaDepan = intent.getStringExtra("fname")
        val namaBelakang = intent.getStringExtra("lname")
        val alamat = intent.getStringExtra("alamat")
        val email = intent.getStringExtra("email")
        val nrp = intent.getStringExtra("nrp")
        binding.inputFName.setText(namaDepan)
        binding.inputLName.setText(namaBelakang)
        binding.inputAlamat.setText(alamat)
        binding.inputNRP.setText(nrp)
        binding.inputEmail.setText(email)


    }
}