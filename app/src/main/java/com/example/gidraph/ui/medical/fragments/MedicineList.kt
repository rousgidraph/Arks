package com.example.gidraph.ui.medical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentMedicineListBinding


class MedicineList : Fragment() {

    private lateinit var binding: FragmentMedicineListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_medicine_list, container, false)
        binding = FragmentMedicineListBinding.bind(view)
        binding.btnAdd.setOnClickListener { findNavController().navigate(R.id.action_medicineList_to_medicine_details) }
        //binding.btnDone.setOnClickListener { // }

        return view
    }


}