package com.example.gidraph.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.databinding.FragmentSettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}