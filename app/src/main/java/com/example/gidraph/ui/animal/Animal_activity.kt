package com.example.gidraph.ui.animal

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



        binding.btnSave.setOnClickListener {
            save_ani()
           // Toast.makeText(applicationContext, "Want some bread with that ", Toast.LENGTH_SHORT).show()
        }
}

    private fun save_ani(){
        var  _type : String
        var _obtained: String
        if (togg_anim_type.isActivated) {_type ="Cow or Goat"}else{_type="Poultry"}
        if (togg_obtained.isActivated){_obtained= "born on farm"}else{_obtained ="bought"}



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
            Toast.makeText(applicationContext, "Want some bread with that ", Toast.LENGTH_SHORT).show()

        }


    }

}