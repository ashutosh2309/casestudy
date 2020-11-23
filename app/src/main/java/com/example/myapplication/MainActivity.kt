package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        viewModel.mutableLiveData.observe(this,object:Observer<ArrayList<MainModel>>{
            override fun onChanged(t: ArrayList<MainModel>?) {
                System.out.println(10)
            }
        })

        viewModel.getAllLeagues();
    }
}