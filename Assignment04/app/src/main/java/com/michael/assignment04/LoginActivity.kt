package com.michael.assignment04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.michael.assignment04.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(email == "mike@email.com" && password == "12345"){
                val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                intent.putExtra("fname","Michael")
                intent.putExtra("lname", "Mathew")
                intent.putExtra("alamat", "Bandung")
                intent.putExtra("email", email)
                intent.putExtra("nrp","2072007")
                startActivity(intent)
                this.finish()
            } else {
                if(email.trim().isEmpty()){
                    binding.etEmail.error = resources.getString(R.string.message_error_email_empty)
                }
                if(password.trim().isEmpty()){
                    binding.etPassword.error = resources.getString(R.string.message_error_pw_empty)
                }
                Snackbar.make(this,binding.button,resources.getString(R.string.msg_failed_login)
                    , Snackbar.LENGTH_LONG).show()
            }
        }
    }
}