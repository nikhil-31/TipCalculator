package com.example.tipcalculator.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.R
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.example.tipcalculator.viewmodel.CalculatorViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.vm = CalculatorViewModel(application)


    }
}
