package com.example.gidraph.ui.medical.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.gidraph.Models.Vet
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.FragmentVetDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class Vet_details : Fragment() {



    @Inject lateinit var dataSource: LocalDataSource
    private lateinit var binding : FragmentVetDetailsBinding
    private lateinit var edit_name : EditText
    private lateinit var edit_email : EditText
    private lateinit var edit_phone : EditText
    private lateinit var edit_comment : EditText




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_vet_details, container, false)
        binding = FragmentVetDetailsBinding.bind(view)
        edit_comment = binding.editComment
        edit_email = binding.editEmail
        edit_name = binding.editName
        edit_phone = binding.editPhone
        binding.btnSave.setOnClickListener { add_vet() }
        binding.btnCancel.setOnClickListener { back_to_visit() }

        return view
    }


    fun add_vet(){
         if (edit_name.text.length < 2){
            edit_name.error = "This cant be that short"

        }else if (edit_phone.text.length < 2){
            edit_phone.error = "This cant be that short"

        }else{
            var temp_vet = Vet(
                name = edit_name.text.toString(),
                phone = edit_phone.text.toString(),
                email = edit_email.text.toString(),
                comment = edit_comment.text.toString()
            )
             dataSource.add_vet(temp_vet)
             back_to_visit()
        }

    }

    fun back_to_visit(){
        findNavController().navigate(R.id.action_vet_details_to_vet_visit)
    }
}