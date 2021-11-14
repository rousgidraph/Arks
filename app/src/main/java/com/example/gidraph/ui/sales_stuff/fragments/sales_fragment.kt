package com.example.gidraph.ui.sales_stuff.fragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gidraph.Models.sale_item
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentSalesFragmentBinding

class sales_fragment : Fragment() {
    private lateinit var binding : FragmentSalesFragmentBinding
    private lateinit var sales : ArrayList<sale_item>
    private lateinit var adapter: CustomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sales_fragment, container, false)
        binding = FragmentSalesFragmentBinding.bind(view)
        binding.btnNewMerch.setOnClickListener { to_merch() }
        sales = ArrayList()
        adapter = CustomAdapter(sales) 
        binding.recyclerSales
        binding.btnAddSale.setOnClickListener { pop_up() }

        
        return view
    }

    private fun to_merch(){
        findNavController().navigate(R.id.action_sales_fragment_to_merchant_details)
    }

    private fun pop_up(){
        var dialog = context?.let { Dialog(it) }
        dialog?.setContentView(R.layout.pop_up_sale)
        // TODO: 15/11/2021 set up the sales items to be read from the database  
        
        
        dialog?.show()
    }


}





class CustomAdapter(private val dataSet: ArrayList<sale_item>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val count : TextView
        val main: TextView

        init {
            count = view.findViewById(R.id.lbl_count)
            main = view.findViewById(R.id.lbl_main)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)

        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO: 14/11/2021  

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}