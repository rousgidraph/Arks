package com.example.gidraph.ui.landing.status

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.example.gidraph.databinding.FragmentStatusFragmentBinding
import com.example.gidraph.ui.weather.Weather
import com.example.gidraph.utils.Grapher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class status_fragment : Fragment() {

    @Inject lateinit var dataSource: LocalDataSource
    @Inject lateinit var Graphs : Grapher

    private lateinit var binding : FragmentStatusFragmentBinding
    private lateinit var graph_one : AnyChartView
    private lateinit var graph_two : AnyChartView
    private lateinit var graph_three : AnyChartView

    private lateinit var set_1 : List<merchant_score>
    private lateinit var set_2 : List<vet_score_view>
    private lateinit var set_3 : List<sale_score>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_status_fragment, container, false)
        binding = FragmentStatusFragmentBinding.bind(view)


        //navigate to weather
        binding.cardWeather.setOnClickListener { to_weather() }
        load_data()


        return view
    }


    fun load_data(){
        //loads all the data for the graphs


        //load merch
        dataSource.load_merchant_score { res -> run{
            Log.i("test ", "load_data: "+res.size)
            set_1 = res
            draw_Overview(set_1)
        } }

        dataSource.load_vet_score { ress -> run {
            set_2 = ress
            draw_graph_two(set_2)
        } }

        dataSource.load_type_score { resss -> run{
            set_3 = resss
            draw_graph_three(set_3)
        } }


    }


    fun draw_Overview(res: List<merchant_score>) {
        Log.i("the ", "draw_Overview: "+res.size)
        var data_1 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        res.forEach { curr -> run {
            data_1.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_one = binding.overviewGraph
        APIlib.getInstance().setActiveAnyChartView(graph_one)
        var carte  = AnyChart.line()
        carte.data(data_1)
        //APIlib.getInstance().setActiveAnyChartView(graph_one)
        graph_one.setChart(carte)
    }

    fun draw_graph_two(ress: List<vet_score_view>) {
        Log.i("something", "draw_graph_two: "+ress.size)
        var data_2 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        ress.forEach { curr -> run {
            data_2.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_two = binding.graphTwo
        APIlib.getInstance().setActiveAnyChartView(graph_two)
        var pie  = AnyChart.pie()
        pie.data(data_2)
        graph_two.setChart(pie)
    }

    fun draw_graph_three(resss: List<sale_score>) {

        var data_3 : ArrayList<DataEntry> = ArrayList<DataEntry>()
        resss.forEach { curr -> run {
            data_3.add(ValueDataEntry(curr.name,curr.total)) // load the data in the thing
        } }


        graph_three = binding.graphThree
        APIlib.getInstance().setActiveAnyChartView(graph_three)
        var pie  = AnyChart.pie()
        pie.data(data_3)
        graph_three.setChart(pie)

    }


    fun sample_pie(){
        Graphs.sample_pie_graph(graph_three)
    }

    fun sample_line(){
        Graphs.sample_bar_graph(graph_two,)

    }

    fun to_weather(){
        var int = Intent(activity,Weather::class.java)
        startActivity(int)
    }

}