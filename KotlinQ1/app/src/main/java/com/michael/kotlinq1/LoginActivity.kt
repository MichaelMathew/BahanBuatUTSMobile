/**
 * Author - Michael Mathew Setiadi / 2072007
 */
package com.michael.kotlinq1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.michael.kotlinq1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val email = binding.etEmail.text.toString()
            val name = email.split("@")[0]
            val password = binding.etPassword.text.toString()
            if(email == "michael@gmail.com" && password == "12345"){
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(Intent.EXTRA_TEXT,name)
                startActivity(intent)

//                Toast.makeText(this@LoginActivity, "Welcome $name", Toast.LENGTH_SHORT).show()
                this.finish()
            } else {
                if(email.trim().isEmpty()){
                    binding.etEmail.error = resources.getString(R.string.message_error_email_empty)
                }
                if(password.trim().isEmpty()){
                    binding.etPassword.error = resources.getString(R.string.message_error_pw_empty)
                }
                Snackbar.make(this,binding.btnLogin,resources.getString(R.string.msg_failed_login)
                    , Snackbar.LENGTH_LONG).show()
            }
        }
    }
}