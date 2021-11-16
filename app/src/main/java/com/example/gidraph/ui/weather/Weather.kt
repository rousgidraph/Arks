package com.example.gidraph.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
    }
}