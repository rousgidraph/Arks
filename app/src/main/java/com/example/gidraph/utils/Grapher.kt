package com.example.gidraph.utils

import android.util.Log
import com.anychart.APIlib
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject

@Module
@InstallIn(ApplicationComponent::class)
class Grapher @Inject constructor() {
    /*
    * this class simply draws all the the necessary graphs ... yep all
    * this class can return the graphs
    * */

    private lateinit var sample_data: ArrayList<DataEntry>

    init {
        sample_data =  ArrayList<DataEntry>()
        sample_data.add(ValueDataEntry("Nairobi",10))
        sample_data.add(ValueDataEntry("Nyeri",100))
        sample_data.add(ValueDataEntry("kisumu",50))
        sample_data.add(ValueDataEntry("kakamega",60))
        sample_data.add(ValueDataEntry("Kajiado",80))



    }


    fun sample_bar_graph(space: AnyChartView, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"){
        // for illustration purposes only
        APIlib.getInstance().setActiveAnyChartView(space)
        var column =  AnyChart.column()
        column.data(sample_data) // this data could be passed in
        column.title(_title)
        column.xAxis(0).title(x_axis)
        column.yAxis(0).title(y_axis)
        space.setChart(column)


    }


    fun sample_line_graph(space: AnyChartView, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"){
        // for illustration purposes only
        APIlib.getInstance().setActiveAnyChartView(space)

        var column =  AnyChart.line()
        column.data(sample_data) // this data could be passed in
        column.title(_title)
        column.xAxis(0).title(x_axis)
        column.yAxis(0).title(y_axis)
        space.setChart(column)


    }

    fun sample_pie_graph(space: AnyChartView, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"){

        APIlib.getInstance().setActiveAnyChartView(space)

        var pie =  AnyChart.pie()
        pie.data(sample_data) // this data could be passed in
        pie.title(_title)

        space.setChart(pie)


    }

    fun data_bar_graph(data: ArrayList<DataEntry>,space: AnyChartView, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"){

        APIlib.getInstance().setActiveAnyChartView(space)
        var column =  AnyChart.column()
        column.data(data)
        column.title(_title)
        column.xAxis(0).title(x_axis)
        column.yAxis(0).title(y_axis)
        space.setChart(column)


    }


    fun data_line_graph(data: ArrayList<DataEntry>, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"): Cartesian{
        Log.i("drawing", "data_line_graph: thinking about you ")


        var column =  AnyChart.line()
        column.data(data)
        column.title(_title)
        column.xAxis(0).title(x_axis)
        column.yAxis(0).title(y_axis)

        Log.i("drawing", "data_line_graph: graph exists")
        return column
    }

    fun data_pie_graph(data: ArrayList<DataEntry>,space: AnyChartView, x_axis :String? = "",y_axis :String? = "", _title :String? = "Click for more details"){

        APIlib.getInstance().setActiveAnyChartView(space)

        var pie =  AnyChart.pie()
        pie.data(data)
        pie.title(_title)

        space.setChart(pie)


    }


}