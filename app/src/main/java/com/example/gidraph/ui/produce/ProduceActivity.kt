package com.example.gidraph.ui.produce

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentProduceDetailsBinding

class produceActivity : AppCompatActivity() {
    private lateinit var binding : FragmentProduceDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProduceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAddProdType.setOnClickListener { custom_dialog() }
    }

    private fun custom_dialog(){
        var dialog : Dialog = Dialog(this)
        dialog.setContentView(R.layout.pop_up_produce)
        dialog.show()

    }
}