package com.example.gidraph.ui.landing.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentHomeFargmentBinding
import com.example.gidraph.ui.medical.medical_activity
import com.example.gidraph.ui.settings.SettingsActivity


class home_fragment : Fragment() {
    private lateinit var binding: FragmentHomeFargmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_fargment, container, false)
        binding = FragmentHomeFargmentBinding.bind(view)
        binding.cardSetting.setOnClickListener {
            to_settings()
        }
        //binding.cardMedicine.setOnClickListener {  }


        return view
    }

    private fun to_settings(){
        var int = Intent(context,SettingsActivity::class.java)
        startActivity(int)
    }

    fun to_medicine(){
        var int = Intent(context,medical_activity::class.java)
        int.putExtra("adress","med")
        startActivity(int)
    }

}