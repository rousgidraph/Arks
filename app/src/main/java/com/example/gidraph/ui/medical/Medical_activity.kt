package com.example.gidraph.ui.medical

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.databinding.ActivityMedicalBinding
import com.example.gidraph.databinding.FragmentMedicineDetailsBinding

class medical_activity : AppCompatActivity() {

    private lateinit var binding :ActivityMedicalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicalBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}