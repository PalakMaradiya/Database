package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.database.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        var database = DataBaseHelper(this,"DatabaseWord.db",null,1)

        binding.btnInsert.setOnClickListener {
//            database.insertData(Fname, Lname, Email, Pass, Number, Age, City, State)

        }

    }
}