package com.example.assign4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assign4.databinding.ActivityAccountCreateBinding

class AccountCreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val rePassword = binding.rePassword.text.toString()
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()){
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_LONG).show()
            } else if (DataHolder.users.any { it.email == email }){
                Toast.makeText(this, "User already exist!", Toast.LENGTH_LONG).show()
            } else if (password != rePassword){
                Toast.makeText(this, "Password doesn't match!", Toast.LENGTH_LONG).show()
            } else{
                DataHolder.users.add(User(name, email, password))
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}