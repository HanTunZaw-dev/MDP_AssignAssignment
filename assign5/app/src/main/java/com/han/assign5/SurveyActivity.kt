package com.han.assign5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.han.assign5.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySurveyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val visible = View.VISIBLE
        if (intent.getStringExtra("choose") == "food") {
            binding.listFood.visibility = visible
            foodSurvey()
        } else {
            binding.listDiet.visibility = visible
            dietSurvey()
        }
    }

    private fun foodSurvey() {
        binding.btnSubmit.setOnClickListener {
            val cuisine = findViewById<RadioButton>(binding.gpCuisine.checkedRadioButtonId)?.text?.toString()
            val oftenEat = findViewById<RadioButton>(binding.gpEat.checkedRadioButtonId)?.text?.toString()
            val spicy = findViewById<RadioButton>(binding.gpSpicy.checkedRadioButtonId)?.text?.toString()
            val vegetarian = findViewById<RadioButton>(binding.gpVegan.checkedRadioButtonId)?.text?.toString()
            val seafood = findViewById<RadioButton>(binding.gpSeafood.checkedRadioButtonId)?.text?.toString()

            val checked = checkEmpty(cuisine, oftenEat, spicy, vegetarian, seafood)
            if (checked){
                val result = "" +
                        "${getString(R.string.what_is_your_favourite_cuisine)} $cuisine \n" +
                        "${getString(R.string.how_often_do_you_eat_out)} $oftenEat \n" +
                        "${getString(R.string.do_you_prefer_spicy_food)} $spicy \n" +
                        "${getString(R.string.do_you_prefer_vegetarian_food)} $vegetarian \n" +
                        "${getString(R.string.do_you_like_seafood)} $seafood \n"

                binding.result.text = result
            }
        }
    }

    private fun dietSurvey() {
        binding.btnSubmit.setOnClickListener {

            val isVegetarian = findViewById<RadioButton>(binding.gpVegetarian.checkedRadioButtonId)?.text?.toString()
            val isOrganic = findViewById<RadioButton>(binding.gpOrganic.checkedRadioButtonId)?.text?.toString()
            val isDairy = findViewById<RadioButton>(binding.gpDiary.checkedRadioButtonId)?.text?.toString()
            val isFastFood = findViewById<RadioButton>(binding.gpFastFood.checkedRadioButtonId)?.text?.toString()
            val isAllergy = findViewById<RadioButton>(binding.gpAllergy.checkedRadioButtonId)?.text?.toString()

            val checked = checkEmpty(isVegetarian, isOrganic, isDairy, isFastFood, isAllergy)
            if (checked){
                val result = "" +
                        "${getString(R.string.are_you_vegetarian)} $isVegetarian \n" +
                        "${getString(R.string.do_you_prefer_organic_food)} $isOrganic \n" +
                        "${getString(R.string.do_you_consume_dairy_products)} $isDairy \n" +
                        "${getString(R.string.do_you_eat_fast_food)} $isFastFood \n" +
                        "${getString(R.string.do_you_have_any_food_allergies)} $isAllergy \n"

                binding.result.text = result
            }
        }
    }

    private fun checkEmpty(vararg inputs: String?): Boolean {
        inputs.forEach { input ->
            if (input.isNullOrBlank()) {
                Toast.makeText(this, "Please answer all questions", Toast.LENGTH_LONG).show()
                return false
            }
        }
        return true
    }

}