package com.example.gidraph.ui.medical.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.gidraph.Models.vet_issue
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentVetVisitBinding
import com.example.gidraph.databinding.PopUpIssueBinding
import com.example.gidraph.ui.medical.medical_activity



class vet_visit : Fragment() {
    private lateinit var binding: FragmentVetVisitBinding
    private lateinit var issues : ArrayList<vet_issue>
    private lateinit var adapter : CustomAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_vet_visit, container, false)
        binding = FragmentVetVisitBinding.bind(view)
        binding.btnAddVet.setOnClickListener { to_vet() }
        binding.btnAddIssue.setOnClickListener { issue_pop_up() }
        issues = ArrayList<vet_issue>()
        adapter = CustomAdapter(issues)
        binding.recyclerView.adapter = adapter

        //binding.btnCancel.setOnClickListener { Toast.makeText(context, "", Toast.LENGTH_SHORT).show() }
        return view
    }


    private fun to_vet(){
        findNavController().navigate(R.id.action_vet_visit_to_vet_details)
    }
    private fun issue_pop_up(){
        var dialog = getContext()?.let { Dialog(it) }

        var binding_pop = PopUpIssueBinding.inflate(layoutInflater)
        //dialog?.setContentView(R.layout.pop_up_issue)
        dialog?.setContentView(binding_pop.root)
        binding_pop.btnDiscard.setOnClickListener {
            dialog?.dismiss()
        }
        binding_pop.btnAdd.setOnClickListener {
            var brief = binding_pop.editBriefDiag
            var desc = binding_pop.editDescription
            if(brief.text.toString().length < 2){
                brief.setError("This cant be blank")

            }  else if(desc.text.toString().length < 2){
                desc.setError("This cant be blank")
            }else{
                var temp_issue = vet_issue(summary = brief.text.toString(), descripton = desc.text.toString())
                issues.add(temp_issue)
                //Log.i("tagged", "issue_pop_up: "+issues.size)
                adapter.notifyDataSetChanged()
                dialog?.dismiss()
            }

        }

        if (dialog != null) {
            dialog.show()
        }
    }
}

class CustomAdapter(private val dataSet: ArrayList<vet_issue>) :
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
        holder.count.text = position.toString()
        holder.main.text  = dataSet[position].summary

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}