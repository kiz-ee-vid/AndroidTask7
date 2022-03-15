package com.example.task_7.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_7.databinding.ActivityMainBinding
import com.example.task_7.presentation.RecyclerAdapter
import com.example.task_7.presentation.ui.vm.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { MainViewModel(this) }
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launch()
    }

    private fun launch() {
        viewModel.apiForm.observe(this, {
            it?.let {
                println(it.fields)
                Glide.with(this)
                    .load(it.image)
                    .into(binding.imageView)
                val recyclerView: RecyclerView = binding.form
                val contactsAdapter = RecyclerAdapter(it.fields)
                recyclerView.adapter = contactsAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        })
    }
}