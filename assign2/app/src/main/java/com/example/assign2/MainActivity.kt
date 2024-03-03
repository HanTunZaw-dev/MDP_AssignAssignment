package com.example.assign2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addData(view: View){

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val addWaterResource = findViewById<EditText>(R.id.waterResource).text.toString()
        val addLocation = findViewById<EditText>(R.id.location).text.toString()
        val addType = findViewById<EditText>(R.id.type).text.toString()
        if (addWaterResource.isEmpty() || addLocation.isEmpty() || addType.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
        } else {
            val tableRow = TableRow(this)

            val viewWaterResource = createTextView(addWaterResource, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val viewLocation = createTextView(addLocation, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            val viewType = createTextView(addType, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            tableRow.addView(viewWaterResource)
            tableRow.addView(viewLocation)
            tableRow.addView(viewType)

            tableLayout.addView(tableRow)
        }
    }
    private fun createTextView(text: String, width: Int, height: Int): TextView {
        val textView = TextView(this)
        textView.text = text
        textView.setPadding(8, 8, 8, 8)
        textView.setBackgroundResource(R.drawable.border)
        val rowParams = TableRow.LayoutParams(width, height)
        textView.layoutParams = rowParams
        return textView
    }

}