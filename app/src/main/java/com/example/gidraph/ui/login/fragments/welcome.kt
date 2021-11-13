package com.example.gidraph.ui.login.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentWelcomeBinding
import com.example.gidraph.ui.landing.MainActivity


class welcome : Fragment() {
    private lateinit var binding : FragmentWelcomeBinding
    private lateinit var btn_login : Button
    private lateinit var  txt_create_account : TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_welcome, container, false)
        binding = FragmentWelcomeBinding.bind(view)

        btn_login = binding.btnLogin
        txt_create_account = binding.lblCreateAccount

        btn_login.setOnClickListener {
            to_home()
        }

        txt_create_account.setOnClickListener { to_create() }

        return view

    }

    fun to_create(){
        findNavController().navigate(R.id.action_welcome_to_create_account)
    }

    fun to_home(){
        var int = Intent(context, MainActivity::class.java)
        startActivity(int)
    }

}