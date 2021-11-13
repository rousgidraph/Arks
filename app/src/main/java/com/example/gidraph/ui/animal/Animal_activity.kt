package com.example.gidraph.ui.animal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gidraph.R
import com.example.gidraph.databinding.ActivityMainBinding
import com.example.gidraph.databinding.FragmentAnimalDetailsBinding
import com.example.gidraph.ui.animal.fragments.animal_details

class Animal_activity : AppCompatActivity()  {
    private lateinit var binding : FragmentAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAnimalDetailsBinding.inflate(layoutInflater)
        //setContentView(R.layout.fragment_animal_details)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            Toast.makeText(applicationContext, "Want some bread with that ", Toast.LENGTH_SHORT).show()
        }
}
}