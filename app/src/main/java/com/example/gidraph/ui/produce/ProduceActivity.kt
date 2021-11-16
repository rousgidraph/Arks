package com.example.gidraph.ui.produce

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import com.example.gidraph.Models.Produce
import com.example.gidraph.Models.produce_type
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.FragmentProduceDetailsBinding
import com.example.gidraph.databinding.PopUpProduceBinding
import com.example.gidraph.ui.landing.MainActivity
import com.example.gidraph.utils.DateFormatter
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList
import javax.inject.Inject

@AndroidEntryPoint
class produceActivity : AppCompatActivity() {

    @Inject lateinit var dater : DateFormatter
    @Inject lateinit var dataSource: LocalDataSource
    private lateinit var spinner_Type : Spinner
    private lateinit var prod_types :List<produce_type>
    private lateinit var selected_type : produce_type //the one currently selected by the spinner
    private lateinit var _date: EditText
    private lateinit var _quality: EditText
    private lateinit var _quantity: EditText
    private lateinit var _comment: EditText




    private lateinit var binding : FragmentProduceDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProduceDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init
        spinner_Type = binding.spinnerType
        spinner_Type.onItemSelectedListener  = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                selected_type = prod_types[p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        _date = binding.editDate
        _date.setText(dater.formatDate(dater.current_time()))
        _quality = binding.editQuality
        _quantity = binding.quantity
        _comment = binding.editComment

        //init methods
        read_prod_types()
        binding.btnSave.setOnClickListener { save_whole_produce() }
        binding.btnAddProdType.setOnClickListener { custom_dialog() }
        binding.btnDiscard.setOnClickListener { back_home() }
    }

    private fun back_home(){
        var  int = Intent(this, MainActivity::class.java)
        startActivity(int)
    }
    
    private fun custom_dialog(){
        var dialog : Dialog = Dialog(this)
        var binding_pop = PopUpProduceBinding.inflate(layoutInflater)
        dialog.setContentView(binding_pop.root)

        var name = binding_pop.editProduceNamePop
        var unit = binding_pop.editUnitsPop

        binding
        //t his is where well add the thuing t the databse
        binding_pop.btnAddProdPop.setOnClickListener {
            if (name.text.length < 1){
                name.error = "This cant be blank"
            }else{
                var temp = produce_type(name.text.toString(),unit.text.toString())

                save_prod_type(temp)
                dialog.dismiss()
                read_prod_types()
                //the prod type should be saved
            }


        }
        dialog.show()

    }

    fun save_prod_type(produceType: produce_type){
        //called by the pop up
        dataSource.add_produce_type(produceType)
    }
    fun read_prod_types(){
        dataSource.get_produce_type { it
        prod_types = it
        load_spinner(prod_types)}
    }

    fun save_whole_produce(){

        if (_quantity.text.length < 1){
            _quantity.error = "This cant be blank"
        }else{
            var temp  = Produce(dater.current_time(),selected_type.type_id,
                _quality.text.toString(),
                _quantity.text.toString().toDouble(),
                _comment.text.toString())
            dataSource.add_produce(temp)
            back_home()
        }


    }
    fun load_spinner(temp : List<produce_type>){
        var disp : MutableList<String> = mutableListOf()
        for (pe in temp) {
            disp.add(pe.produce_name)
        }

        val adapt = ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,disp)
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_Type.adapter = adapt

    }
}