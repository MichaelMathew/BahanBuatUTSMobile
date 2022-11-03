package com.michael.assignment04

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.michael.assignment04.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val namaDepan = intent.getStringExtra("fname")
        val namaBelakang = intent.getStringExtra("lname")
        val alamat = intent.getStringExtra("alamat")
        val email = intent.getStringExtra("email")
        val nrp = intent.getStringExtra("nrp")
        binding.txtEmail.text = email
        binding.txtNrp.text = nrp
        binding.txtAlamat.text = alamat
        binding.txtNameDepan.text = namaDepan
        binding.txtNameBelakang.text = namaBelakang
        binding.txtEmail.text = email
    }

    override fun onStart() {
        super.onStart()


        val namaDepan = binding.txtNameDepan.text.toString()
        val namaBelakang = binding.txtNameBelakang.text.toString()
        val alamat = binding.txtAlamat.text.toString()
        val email = binding.txtEmail.text.toString()
        val nrp = binding.txtNrp.text.toString()
        binding.btnEdit.setOnClickListener {
            val intent = Intent(this@ProfileActivity, EditProfileActivity::class.java)
            intent.putExtra("fname",namaDepan)
            intent.putExtra("lname", namaBelakang)
            intent.putExtra("alamat", alamat)
            intent.putExtra("email", email)
            intent.putExtra("nrp",nrp)
            startActivity(intent)
        }
    }
}