package com.example.gidraph.ui.sales_stuff.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.gidraph.Models.Merchant
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.FragmentMerchantDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class Merchant_details : Fragment() {
    private lateinit var binding : FragmentMerchantDetailsBinding
    @Inject lateinit var dataSource: LocalDataSource
    private lateinit var _name : EditText
    private lateinit var _email : EditText
    private lateinit var _phone : EditText
    private lateinit var _comment : EditText
    private lateinit var _btn_save : Button
    private lateinit var _btn_cancel : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_merchant_details, container, false)
        binding = FragmentMerchantDetailsBinding.bind(view)
        _name = binding.editName
        _email = binding.editEmail
        _phone = binding.editPhone
        _comment = binding.editComment
        _btn_cancel = binding.btnCancel
        _btn_save = binding.btnSave
        _btn_save.setOnClickListener { save_merchant() }
        _btn_cancel.setOnClickListener { back() }


        return view
    }

    private fun save_merchant(){
        if (_name.text.toString().length < 2){
            _name.error = "Too short "
        }else if (_phone.text.toString().length < 2){
            _phone.error = "Too short"
        }else{
            var temp_merch = Merchant(
                name = _name.text.toString(),
                phone = _phone.text.toString(),
                email = _email.text.toString(),
                comment = _comment.text.toString()
            )

            dataSource.add_merchant(temp_merch)
            back()

        }

            }



    private fun back(){
        activity?.onBackPressed()
    }

}