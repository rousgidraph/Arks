package com.example.gidraph.ui.sales_stuff.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gidraph.Models.*
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.FragmentSalesFragmentBinding
import com.example.gidraph.databinding.PopUpSaleBinding
import com.example.gidraph.ui.landing.MainActivity
import com.example.gidraph.utils.DateFormatter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class sales_fragment : Fragment() {
    private lateinit var binding : FragmentSalesFragmentBinding
    private lateinit var sales : ArrayList<sale_item>
    private lateinit var adapter: CustomAdapter
    private lateinit var mercantList: List<Merchant>
    private lateinit var merch_drop : Spinner
    private lateinit var types_list : List<sale_type>
    @Inject lateinit var dater : DateFormatter
    @Inject lateinit var dataSource: LocalDataSource
    private lateinit var selectedMerch : Merchant

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sales_fragment, container, false)
        binding = FragmentSalesFragmentBinding.bind(view)
        binding.editDate.setText(dater.formatDate(dater.current_time()))
        binding.btnNewMerch.setOnClickListener { to_merch() }
        sales = ArrayList()
        types_list = ArrayList()
        adapter = CustomAdapter(sales) 
        binding.recyclerSales.adapter = adapter
        merch_drop = binding.spinnerMerchant
        merch_drop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selectedMerch = mercantList[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        load_merchants()
        load_sale_types()
        binding.btnAddSale.setOnClickListener { pop_up()
        }
        binding.btnCancel.setOnClickListener { back_home() }
        binding.btnSave.setOnClickListener { save_major()
            }
        
        return view
    }

    private fun to_merch(){
        findNavController().navigate(R.id.action_sales_fragment_to_merchant_details)
    }

    private fun back_home(){
        var  int = Intent(activity,MainActivity::class.java)
        startActivity(int)
    }

    private fun pop_up(){
        var dialog = context?.let { Dialog(it) }
        var binding_pop  = PopUpSaleBinding.inflate(layoutInflater)
        dialog?.setContentView(binding_pop.root)

        var temp_list : MutableList<String> = mutableListOf()
        types_list.forEach { type ->
            temp_list.add(type.sale_name)
        }
        val aadapter = context?.let {
            ArrayAdapter<String>(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                temp_list
            )
        }
        aadapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding_pop.spinnerSaleType.adapter = aadapter

        binding_pop.btnNewSalePop.setOnClickListener {
            to_sale_item()
            dialog?.dismiss()
        }
        binding_pop.btnDiscardPopSale.setOnClickListener { dialog?.dismiss() }

        binding_pop.btnAddPopSale.setOnClickListener {
            if(binding_pop.popSaleCount.text.length < 1){
                binding_pop.popSaleCount.error = "add a valid number"
            }else{
                var temp_sale = sale_item(0,
                    types_list[binding_pop.spinnerSaleType.selectedItemPosition].sale_type_id,
                    binding_pop.popSaleCount.text.toString().toDouble(),
                    types_list[binding_pop.spinnerSaleType.selectedItemPosition].sale_name)
                sales.add(temp_sale)
                adapter.notifyDataSetChanged()
                dialog?.dismiss()

            }
        }


        
        
        dialog?.show()
    }

    private fun load_sale_types(){

        dataSource.get_sale_types {
            types_list = it
        }
    }

    private fun load_merchants(){
        dataSource.load_merchs {
            mercantList = it
            loadSpinner(mercantList)
        }
    }
    fun loadSpinner ( peeps : List<Merchant>){
        //Toast.makeText(this, ""+peeps.get(0).name, Toast.LENGTH_SHORT).show()
        var names : MutableList<String> = mutableListOf()
        peeps.forEach { merch ->
            names.add(merch.name)
        }

        val adapter = context?.let {
            ArrayAdapter<String>(
                it,
                R.layout.support_simple_spinner_dropdown_item,
                names
            )
        }
        adapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        merch_drop.adapter = adapter
    }

    private fun to_sale_item(){
        findNavController().navigate(R.id.action_sales_fragment_to_new_sale_item)
    }

    private fun save_major(){
        //selectedMerch =
        if (binding.editTotal.text.length < 2){
            binding.editTotal.error = "This cant be blank"
        }else{
            var temp_record = Sale(dater.current_time(),selectedMerch.id,binding.editTotal.text.toString().toDouble())
            var new_id : Long
            dataSource.add_sale(temp_record) { it ->
                new_id = it
                save_all(new_id)
            }
            back_home()

        }

    }

    private fun save_all(use_id: Long){
        // the records are in sales
        //for each create a temp assing the id given and then save
        // TODO: 16/11/2021 incase of any issues this is the place
        for (sale in sales) {
            sale.sale_id = use_id
            dataSource.add_sale_items(sale)
        }

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
        holder.count.text = dataSet[position].item_count.toString()
        holder.main.text =  dataSet[position].sale_name.toString()


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}