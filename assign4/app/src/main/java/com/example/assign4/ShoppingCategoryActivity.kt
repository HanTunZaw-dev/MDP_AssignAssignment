package com.example.assign4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assign4.databinding.ActivityShoppingCategoryBinding

class ShoppingCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userName = intent.getStringExtra("userName")
        binding.idWelcome.text = getString(R.string.welcome, userName)
    }
}