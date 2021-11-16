package com.example.gidraph.ui.animal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ToggleButton
import com.example.gidraph.Models.Animal
import com.example.gidraph.R
import com.example.gidraph.database.LocalDataSource
import com.example.gidraph.databinding.ActivityMainBinding
import com.example.gidraph.databinding.FragmentAnimalDetailsBinding
import com.example.gidraph.ui.animal.fragments.animal_details
import com.example.gidraph.ui.landing.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Animal_activity : AppCompatActivity()  {
    private lateinit var binding : FragmentAnimalDetailsBinding
    private lateinit var edit_anim_name : EditText
    private lateinit var togg_anim_type : ToggleButton
    private lateinit var togg_obtained : ToggleButton
    private lateinit var btn_discard : Button
    private lateinit var btn_save : Button
    private lateinit var edit_anim_breed : EditText
    private lateinit var edit_anim_comment : EditText
    private lateinit var _type : String
    private lateinit var  _obtained: String

    @Inject
    lateinit var dataSource : LocalDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAnimalDetailsBinding.inflate(layoutInflater)
        //setContentView(R.layout.fragment_animal_details)
        setContentView(binding.root)

        //declare
        edit_anim_breed = binding.editBreed
        edit_anim_comment = binding.editComment
        togg_anim_type  = binding.toggleAniType
        edit_anim_name = binding.editAniName
        togg_obtained = binding.toggleObtained
        btn_discard = binding.btnDiscard
        btn_save = binding.btnSave
        togg_anim_type.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked) {_type ="Cow or Goat"}else{_type="Poultry"}
        }
        togg_obtained.setOnCheckedChangeListener{_,isChecked ->
            if (isChecked){_obtained= "born on farm"}else{_obtained ="bought"}

        }

        binding.btnDiscard.setOnClickListener { back_home() }
        binding.btnSave.setOnClickListener {
            save_ani()
           // Toast.makeText(applicationContext, "Want some bread with that ", Toast.LENGTH_SHORT).show()
        }
}

    private fun back_home(){
        var  int = Intent(this, MainActivity::class.java)
        startActivity(int)
    }

    private fun save_ani(){
        if (edit_anim_name.text.length < 1){
            edit_anim_name.error = "This cant be blank "
        }else{
            var tempani = Animal(
                animal_name = edit_anim_name.text.toString(),
                breed = edit_anim_breed.text.toString(),
                date_of_birth = 5,
                origin = _obtained,
                animal_type = _type)
            dataSource.addanimal(tempani)
            //Toast.makeText(applicationContext, "Want some bread with that ", Toast.LENGTH_SHORT).show()
            back_home()
        }


    }

}