package com.example.msiza1eatery

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale

class TimeInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timeinformation)

        val etTime = findViewById<EditText>(R.id.etTime)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnCheckTime = findViewById<Button>(R.id.buttonBreakfast)

        btnCheckTime.setOnClickListener {
            val userInputTime = etTime.text.toString().trim()

            if (userInputTime.isEmpty()) {
                Toast.makeText(this, "Please enter a time!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

            try {
                val enteredTime = timeFormat.parse(userInputTime) ?: return@setOnClickListener

                val breakfastStart = timeFormat.parse("06:30")
                val breakfastEnd = timeFormat.parse("11:30")

                val lunchStart = timeFormat.parse("11:31")
                val lunchEnd = timeFormat.parse("14:30")

                val supperStart = timeFormat.parse("14:31")
                val supperEnd = timeFormat.parse("20:00")

                tvMessage.text = when {
                    enteredTime in breakfastStart..breakfastEnd -> "It's Breakfast Time!"
                    enteredTime in lunchStart..lunchEnd -> "It's Lunch Time!"
                    enteredTime in supperStart..supperEnd -> "It's Supper Time!"
                    else -> "Not a meal time!"
                }

            } catch (e: Exception) {
                Toast.makeText(this, "Invalid time format! Use HH:mm (e.g., 08:30)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
