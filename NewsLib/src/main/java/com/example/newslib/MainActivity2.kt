package com.example.newslib

import Adapter
import ApiService
import MainRepository
import ModuleApi
import MyResponse
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newslib.databinding.ActivityMain2Binding
import com.example.newslib.viewModel.MainViewModel
import com.example.newslib.viewModel.ViewModelFactory


class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: Adapter
    private lateinit var viewModel: MainViewModel
    private lateinit var repository: MainRepository
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val apiService = ModuleApi.getInstance().create(ApiService::class.java)
        repository = MainRepository(apiService,applicationContext)
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.rv.layoutManager = LinearLayoutManager(this)

        viewModel.itemsLiveData.observe(this) {
            when(it) {
                is MyResponse.Success<*> -> {
                    adapter = Adapter(it.data!!.results)
                    binding.rv.adapter = adapter
                }
                is MyResponse.Error<*> -> {
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_LONG).show()
                }

                else -> {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
        }

        //viewModel.fetchItems()
        binding.btnPrev.setOnClickListener{
            setResult(Activity.RESULT_OK)

            // Finish the target activity
            finish()
        }
    }
    companion object {
        fun getInstance(context: Context) = Intent(context,MainActivity2::class.java)
    }
}