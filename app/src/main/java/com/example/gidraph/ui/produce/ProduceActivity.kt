package com.example.gidraph.ui.produce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.databinding.FragmentProduceDetailsBinding

class produceActivity : AppCompatActivity() {
    private lateinit var binding : FragmentProduceDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProduceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}