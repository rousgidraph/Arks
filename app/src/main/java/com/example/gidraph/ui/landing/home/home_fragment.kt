package com.example.gidraph.ui.landing.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gidraph.R
import com.example.gidraph.databinding.FragmentHomeFargmentBinding
import com.example.gidraph.ui.animal.Animal_activity
import com.example.gidraph.ui.history.produce_history.produce_hist
import com.example.gidraph.ui.history.sales_history.sales_hist
import com.example.gidraph.ui.medical.Medicine
import com.example.gidraph.ui.medical.medical_activity
import com.example.gidraph.ui.produce.produceActivity
import com.example.gidraph.ui.sales_stuff.Sales_activity
import com.example.gidraph.ui.search.searchActivity
import com.example.gidraph.ui.settings.SettingsActivity


class home_fragment : Fragment() {
    private lateinit var binding: FragmentHomeFargmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home_fargment, container, false)
        binding = FragmentHomeFargmentBinding.bind(view)
        binding.cardSetting.setOnClickListener {  to_settings()  }
        binding.cardSaleHistory.setOnClickListener { to_sale_hist() }
        binding.cardProduceHist.setOnClickListener { to_prod_hist() }
        binding.cardSearch.setOnClickListener { to_search() }
        binding.cardExit.setOnClickListener { exit_app() }
        binding.cardAnimal.setOnClickListener { to_ani() }
        binding.cardAddProduce.setOnClickListener { toProduuce() }
        binding.cardAddVetVisit.setOnClickListener { to_med() }
        binding.cardSale.setOnClickListener { to_sale() }
        binding.cardMedicine.setOnClickListener { to_medicine() }


        return view
    }

    private fun to_settings(){
        var int = Intent(context,SettingsActivity::class.java)
        startActivity(int)
    }

    private fun exit_app(){
        activity?.finish()
        System.exit(0)
    }

    private fun to_search(){
        var int = Intent(context,searchActivity::class.java)
        startActivity(int)
    }


    fun to_medicine(){
        var int = Intent(context, Medicine::class.java)

        startActivity(int)
    }

    private fun to_ani(){
        var int = Intent(context, Animal_activity::class.java)
        startActivity(int)
    }

    private fun to_med(){
        var int = Intent(context,medical_activity::class.java)
        startActivity(int)
    }

    private fun to_sale(){
        var int = Intent(context, Sales_activity::class.java)
        startActivity(int)

    }

    private fun toProduuce(){
        var int = Intent(context, produceActivity::class.java)
        startActivity(int)
    }

    private fun to_sale_hist(){
        var int = Intent(context, sales_hist::class.java)
        startActivity(int)
    }

    private fun to_prod_hist(){
        var int = Intent(context, produce_hist::class.java)
        startActivity(int)
    }

}