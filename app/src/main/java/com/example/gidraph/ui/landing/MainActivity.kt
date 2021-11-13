package com.example.gidraph.ui.landing

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.gidraph.R
import com.example.gidraph.databinding.ActivityMainBinding
import com.example.gidraph.ui.animal.Animal_activity
import com.example.gidraph.ui.animal.fragments.animal_details
import com.example.gidraph.ui.medical.medical_activity
import com.example.gidraph.ui.produce.produceActivity
import com.example.gidraph.ui.sales_stuff.Sales_activity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    private var clicked : Boolean = false

    private lateinit var fab_main : FloatingActionButton
    private lateinit var fab_med : FloatingActionButton
    private lateinit var fab_prod : FloatingActionButton
    private lateinit var fab_sale : FloatingActionButton
    private lateinit var fab_ani : FloatingActionButton


    //animations
    private val rotateOpen : Animation by lazy { AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_open_anim) }
    private val rotateClose : Animation by lazy { AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_close_anim) }
    private val fromBottom : Animation by lazy { AnimationUtils.loadAnimation(applicationContext,R.anim.from_bottom_anim) }
    private val toBottom : Animation by lazy { AnimationUtils.loadAnimation(applicationContext,R.anim.to_bottom_anim) }


    // TODO: 12/11/2021 implement the security and on boarding  
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        tabLayout = binding.tabLayout
        viewPager = binding.pager

        var pagerAdapter = pagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)

        /*fabs logic*/
        fab_main = binding.fabMain
        fab_ani = binding.fabAnimal
        fab_med= binding.fabMed
        fab_sale = binding.fabSale
        fab_prod = binding.fabProduce


        fab_main.setOnClickListener {
            onMainClicked()


        }
        fab_prod.setOnClickListener {
            //Toast.makeText(applicationContext, " prod Clicked", Toast.LENGTH_SHORT).show()
            toProduuce()
        }
        fab_sale.setOnClickListener {
            //Toast.makeText(applicationContext, " sale Clicked", Toast.LENGTH_SHORT).show()
            to_sale()
        }
        fab_med.setOnClickListener {
            //Toast.makeText(applicationContext, " med Clicked", Toast.LENGTH_SHORT).show()
            to_med()
        }
        fab_ani.setOnClickListener {
            //Toast.makeText(applicationContext, " ani Clicked", Toast.LENGTH_SHORT).show()
            to_ani()
        }







    }

    private fun onMainClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked


    }

    private fun setAnimation(clicked : Boolean) {
        if(!clicked){
            fab_ani.startAnimation(fromBottom)
            fab_med.startAnimation(fromBottom)
            fab_sale.startAnimation(fromBottom)
            fab_prod.startAnimation(fromBottom)
            fab_main.startAnimation(rotateOpen)
        }else{
            fab_ani.startAnimation(toBottom)
            fab_med.startAnimation(toBottom)
            fab_sale.startAnimation(toBottom)
            fab_prod.startAnimation(toBottom)
            fab_main.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked : Boolean) {
        if (!clicked){
            fab_ani.visibility = View.VISIBLE
            fab_med.visibility = View.VISIBLE
            fab_sale.visibility = View.VISIBLE
            fab_prod.visibility = View.VISIBLE
        }else{
            fab_ani.visibility = View.GONE
            fab_med.visibility = View.GONE
            fab_sale.visibility = View.GONE
            fab_prod.visibility = View.GONE
        }
    }


    private fun to_ani(){
        var int = Intent(applicationContext,Animal_activity::class.java)
        startActivity(int)
    }

    private fun to_med(){
        var int = Intent(applicationContext,medical_activity::class.java)
        startActivity(int)
    }

    private fun to_sale(){
        var int = Intent(applicationContext,Sales_activity::class.java)
        startActivity(int)

    }

    private fun toProduuce(){
        var int = Intent(applicationContext,produceActivity::class.java)
        startActivity(int)
    }
}