package com.example.gidraph.ui.history.sales_history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gidraph.R
import com.example.gidraph.databinding.ActivitySalesBinding
import com.example.gidraph.databinding.ActivitySalesHistBinding
import com.example.gidraph.ui.sales_stuff.Sales_activity

class sales_hist : AppCompatActivity() {
    private lateinit var binding : ActivitySalesHistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesHistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener { to_sale() }
        binding.btnDone.setOnClickListener { this.onBackPressed() }

    }


    private fun to_sale(){
        var int = Intent(this, Sales_activity::class.java)
        startActivity(int)

    }
}