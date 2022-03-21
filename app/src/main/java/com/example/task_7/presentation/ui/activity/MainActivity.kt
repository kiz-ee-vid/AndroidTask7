package com.example.task_7.presentation.ui.activity

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task_7.databinding.ActivityMainBinding
import com.example.task_7.presentation.di.App
import com.example.task_7.presentation.ui.vm.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.task_7.R.string.OK

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProvider(
            this,
            factory
        ).get(MainViewModel::class.java)
    }
    lateinit var contactsAdapter: RecyclerAdapter
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        (application as App).getAppComponent().inject(this)
        binding.progressBar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.Default).launch {
            while (!checkInternetConnection())
                delay(3000)
            runOnUiThread() {
                viewModel.getData()
            }
        }

        viewModel.apiForm.observe(this, {
            it?.let {
                supportActionBar?.title = it.title
                val recyclerView: RecyclerView = binding.form
                contactsAdapter = RecyclerAdapter(it.fields)
                Glide.with(this)
                    .load(it.image)
                    .into(binding.imageView)
                binding.progressBar.visibility = View.INVISIBLE
                recyclerView.adapter = contactsAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        })

        binding.submitButton.setOnClickListener() {
            if (checkInternetConnection()) {
                binding.progressBar.visibility = View.VISIBLE
                viewModel.sendPost(contactsAdapter.map) {
                    AlertDialog.Builder(this)
                        .setMessage(it.result)
                        .setPositiveButton(getString(OK), null)
                        .create()
                        .show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun checkInternetConnection(): Boolean {
        val connection =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connection.activeNetwork != null
    }
}