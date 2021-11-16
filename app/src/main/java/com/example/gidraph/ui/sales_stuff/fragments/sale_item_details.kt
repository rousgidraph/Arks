package com.example.gidraph.ui.sales_stuff.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.gidraph.Models.sale_type
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.FragmentSaleItemDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class new_sale_item : Fragment() {
    private lateinit var binding : FragmentSaleItemDetailsBinding
    @Inject lateinit var dataSource: LocalDataSource
    private lateinit var name: EditText
    private lateinit var  description : EditText
    private lateinit var btn_save : Button
    private lateinit var btn_discard : Button

    // TODO: 16/11/2021  
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sale_item_details, container, false)
        binding = FragmentSaleItemDetailsBinding.bind(view)
        name = binding.editSaleName
        description = binding.editDescriptionSaleItem
        binding.btnSave.setOnClickListener { save_data() }
        binding.btnDiscard.setOnClickListener { back() }
        return view
    }

    fun save_data(){
        if(name.text.toString().length < 2){
            name.error = "This cant be this short "
        }else{
            var temp = sale_type(name.text.toString(),description.text.toString())
            dataSource.add_sale_type(temp)
            back()
        }
    }


    fun back(){
        activity?.onBackPressed()
    }
   
}