package com.example.mealapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mealapp.data.models.Category as Category1

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_up)
    }


}