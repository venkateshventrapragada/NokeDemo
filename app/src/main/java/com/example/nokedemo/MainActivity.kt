package com.example.nokedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.nokedemo.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val listOfPeople = readFromJson()
        binding.listview.isClickable = true
        binding.listview.adapter = PeopleAdapter(this, listOfPeople)
    }

    fun readFromJson(): List<User> {
        val jsonString = this.assets.open("People.json").bufferedReader().use {
            it.readText()
        }
        val peopleList = Gson().fromJson(jsonString, People::class.java)
        return peopleList.people
    }
}