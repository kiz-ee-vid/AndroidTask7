package com.example.task_7.presentation.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_7.databinding.ActivityMainBinding
import com.example.task_7.presentation.RecyclerAdapter
import com.example.task_7.presentation.di.App
import com.example.task_7.presentation.ui.vm.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            factory
        ).get(MainViewModel::class.java)
    }
    lateinit var contactsAdapter : RecyclerAdapter
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        launch()
    }

    private fun launch() {
        (application as App).getAppComponent().inject(this)
        viewModel.apiForm.observe(this, {
            it?.let {
                Glide.with(this)
                    .load(it.image)
                    .into(binding.imageView)
                val recyclerView: RecyclerView = binding.form
                contactsAdapter = RecyclerAdapter(it.fields, this)
                recyclerView.adapter = contactsAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        })

        viewModel.apiResponse.observe(this, {
            AlertDialog.Builder(this)
                .setMessage(it.result)
                .setPositiveButton("OK", null)
                .create()
                .show()
        })

        binding.button.setOnClickListener(){
            viewModel.sendPost(contactsAdapter.map)
        }
    }
}