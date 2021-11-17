package com.example.gidraph.ui.history.produce_history

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gidraph.Models.Produce
import com.example.gidraph.Models.Vet_issue
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.ActivityProduceHistBinding
import com.example.gidraph.ui.produce.produceActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class produce_hist : AppCompatActivity() {
    private lateinit var binding : ActivityProduceHistBinding
    private lateinit var adapter : CustomAdapter
    private lateinit var dataSet: List<Produce>
    @Inject
    lateinit var dataSource: LocalDataSource
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProduceHistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAdd.setOnClickListener { toProduuce() }
        binding.btnDone.setOnClickListener { this.onBackPressed() }
        recyclerView = binding.prodRecycler
        dataSet = ArrayList<Produce>()
        load_data()

    }
    private fun toProduuce(){
        var int = Intent(this, produceActivity::class.java)
        startActivity(int)
    }

    private fun load_data(){
        dataSource.load_all_produce {
            dataSet = it
            adapter = CustomAdapter(dataSet as ArrayList<Produce>)
            recyclerView.adapter = adapter
        }
        Log.i("some ", "load_data: "+dataSet.size)

    }

}

class CustomAdapter(private val dataSet: ArrayList<Produce>) : // this calss helps load the recycler view
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
        holder.count.text = dataSet[position].produce_id.toString()
        holder.main.text  = dataSet[position].comment.toString()+" pieces( "+dataSet[position].quanity+" ) "

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}