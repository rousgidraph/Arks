package com.example.gidraph.ui.sales_stuff.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentSaleItemDetailsBinding


class new_sale_item : Fragment() {
    private lateinit var binding : FragmentSaleItemDetailsBinding
    // TODO: 15/11/2021 fill up this class  
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sale_item_details, container, false)
    }

   
}