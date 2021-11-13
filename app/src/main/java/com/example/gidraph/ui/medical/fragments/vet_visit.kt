package com.example.gidraph.ui.medical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentVetVisitBinding


class vet_visit : Fragment() {
    private lateinit var binding: FragmentVetVisitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_vet_visit, container, false)
        binding = FragmentVetVisitBinding.bind(view)
        binding.btnAddVet.setOnClickListener { to_vet() }

        return view
    }


    private fun to_vet(){
        findNavController().navigate(R.id.action_vet_visit_to_vet_details)
    }
}