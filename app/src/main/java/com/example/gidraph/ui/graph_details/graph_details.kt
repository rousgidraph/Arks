package com.example.gidraph.ui.graph_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.anychart.APIlib
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.example.gidraph.Models.views.merchant_score
import com.example.gidraph.Models.views.sale_score
import com.example.gidraph.Models.views.vet_score_view
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.ActivityGraphDetailsBinding
import com.example.gidraph.ui.landing.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class graph_details : AppCompatActivity() {
    private lateinit var binding:ActivityGraphDetailsBinding
    @Inject
    lateinit var dataSource: LocalDataSource

    private lateinit var set_1 : List<merchant_score>
    private lateinit var set_2 : List<vet_score_view>
    private lateinit var set_3 : List<sale_score>

    private lateinit var graph_main : AnyChartView

    private lateinit var data_1 : ArrayList<DataEntry>
    private lateinit var data_2 : ArrayList<DataEntry>
    private lateinit var data_3 : ArrayList<DataEntry>

    private  var _x : String? = ""
    private  var _y : String? = ""
    private  var _title : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGraphDetailsBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_graph_details)
        setContentView(binding.root)
        var extras = intent.extras
        if(extras != null){
            var value  = extras["data"]
             _title  = extras["title"] as String
             _x = extras["x"] as String
             _y  = extras["y"] as String
            Log.i("not empty", "onCreate: "+value)
            binding.lblTitle.text = _title
            load_data(value as String)
        }


        binding.btnDone.setOnClickListener { back_home() }
    }



    private fun back_home(){
        var  int = Intent(this, MainActivity::class.java)
        startActivity(int)
    }

    fun load_data(which : String){
        //loads all the data for the graphs

        when (which){
            "merch" ->{
                //load merch
                dataSource.load_merchant_score { res -> run{
                    Log.i("test ", "load_data: "+res.size)
                    set_1 = res
                    draw_Overview(set_1)
                } }
            }
            "vet" ->{
                dataSource.load_vet_score { ress -> run {
                    set_2 = ress
                    draw_graph_two(set_2)
                } }
            }
            "sale" ->{
                dataSource.load_type_score { resss -> run{
                    set_3 = resss
                    draw_graph_three(set_3)
                } }

            }
            else ->{
                //load merch
                dataSource.load_merchant_score { res -> run{
                    Log.i("test ", "load_data: "+res.size)
                    set_1 = res
                    draw_Overview(set_1)
                } }
            }
        }







    }


    fun draw_Overview(res: List<merchant_score>) {
        Log.i("the ", "draw_Overview: "+res.size)
        data_1  = ArrayList<DataEntry>()
        res.forEach { curr -> run {
            data_1.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_main = binding.biggerGraph
        APIlib.getInstance().setActiveAnyChartView(graph_main)
        var carte  = AnyChart.line()
        carte.data(data_1)

        //APIlib.getInstance().setActiveAnyChartView(graph_one)
        graph_main.setChart(carte)


    }

    fun draw_graph_two(ress: List<vet_score_view>) {
        Log.i("something", "draw_graph_two: "+ress.size)
        data_2 = ArrayList<DataEntry>()
        ress.forEach { curr -> run {
            data_2.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_main = binding.biggerGraph
        APIlib.getInstance().setActiveAnyChartView(graph_main)
        var pie  = AnyChart.pie()
        pie.data(data_2)
        graph_main.setChart(pie)

    }

    fun draw_graph_three(resss: List<sale_score>) {

        data_3 = ArrayList<DataEntry>()
        resss.forEach { curr -> run {
            data_3.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_main = binding.biggerGraph
        APIlib.getInstance().setActiveAnyChartView(graph_main)
        var pie  = AnyChart.pie()
        pie.data(data_3)
        graph_main.setChart(pie)

    }
}