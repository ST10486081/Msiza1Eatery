package com.example.msiza1eatery

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // Set click listener to open BreakfastMenuActivity
        buttonBreakfast.setOnClickListener {
            val intent = Intent(this, T::class.java)
            startActivity(intent)
        }
    }
}
