package com.example.gidraph.ui.sales_stuff.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentSalesFragmentBinding

class sales_fragment : Fragment() {
    private lateinit var binding : FragmentSalesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sales_fragment, container, false)
        binding = FragmentSalesFragmentBinding.bind(view)
        binding.btnNewMerch.setOnClickListener { to_merch() }

        return view
    }

    private fun to_merch(){
        findNavController().navigate(R.id.action_sales_fragment_to_merchant_details)
    }
}