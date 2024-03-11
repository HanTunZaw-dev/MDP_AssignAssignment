package com.example.assign4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.assign4.databinding.ActivityShoppingCategoryBinding

class ShoppingCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = intent.getStringExtra("userName")
        binding.idWelcome.text = getString(R.string.welcome, userName)

        binding.home.setOnClickListener{
            Toast.makeText(this, "${binding.home.contentDescription}", Toast.LENGTH_LONG).show()
        }
        binding.beauty.setOnClickListener{
            Toast.makeText(this, "${binding.beauty.contentDescription}", Toast.LENGTH_LONG).show()
        }
        binding.pet.setOnClickListener{
            Toast.makeText(this, "${binding.pet.contentDescription}", Toast.LENGTH_LONG).show()
        }
        binding.toy.setOnClickListener{
            Toast.makeText(this, "${binding.toy.contentDescription}", Toast.LENGTH_LONG).show()
        }
    }
}