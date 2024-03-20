package com.han.assign5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.han.assign5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSurvey.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            val selected = if(binding.survey.checkedRadioButtonId == R.id.food){
                "food"
            }else{
                "diet"
            }
            intent.putExtra("choose", selected)
            startActivity(intent)
        }
    }
}