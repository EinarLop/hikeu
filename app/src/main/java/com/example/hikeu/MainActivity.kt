package com.example.hikeu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hikeu.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewModel = ViewModelProvider(this,HikeuViewModelFactory((application as
                HikeuApp).database.MainDao())).get(HikeuViewModel::class.java)



    lifecycleScope.launch {
        val user = Users("einarpop", "123", "eina@mail.com")
        var us = viewModel.addUser(user)
        Log.d("db", us.toString())
        val users = viewModel.getAllUsers()
        Log.d("db", users.toString())
    }





    }
}