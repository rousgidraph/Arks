package com.example.gidraph.ui.medical

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.gidraph.R
import com.example.gidraph.databinding.ActivityMedicalBinding
import com.example.gidraph.databinding.FragmentMedicineDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class medical_activity : AppCompatActivity() {

    private lateinit var binding :ActivityMedicalBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var extras = intent.extras




    }
}