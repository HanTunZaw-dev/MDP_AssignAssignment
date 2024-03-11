package com.example.assign4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assign4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all field", Toast.LENGTH_LONG).show()
            } else {
                val loggedInUser = DataHolder.users.find { it.email == email && it.password == password }
                if (loggedInUser != null) {
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)
                    intent.putExtra("userName", loggedInUser.name)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Login Unsuccessful!", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnNewAcc.setOnClickListener {
            startActivity(Intent(this, AccountCreateActivity::class.java))
        }
    }
}