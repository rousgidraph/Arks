package com.example.gidraph.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.R
import com.example.gidraph.databinding.ActivityLoginStuffBinding

class login_stuff : AppCompatActivity() {
    private lateinit var binding : ActivityLoginStuffBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginStuffBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_login_stuff)
    }
}