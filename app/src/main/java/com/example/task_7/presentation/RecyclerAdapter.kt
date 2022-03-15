package com.example.task_7.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_7.data.FieldItem
import com.example.task_7.databinding.ListItemBinding
import com.example.task_7.domain.utils.Constants

class RecyclerAdapter(var fieldsList: List<FieldItem>) :
    RecyclerView.Adapter<RecyclerAdapter.ContactHolder>() {

    inner class ContactHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        with(holder) {
            binding.textView.text = fieldsList[position].name
            when (fieldsList[position].type) {
                Constants.TEXT -> {
                    binding.TEXT.visibility = View.VISIBLE
                    binding.NUMERIC.visibility = View.GONE
                    binding.LIST.visibility = View.GONE
                }
                Constants.NUMERIC -> {
                    binding.TEXT.visibility = View.GONE
                    binding.NUMERIC.visibility = View.VISIBLE
                    binding.LIST.visibility = View.GONE
                }
                Constants.LIST -> {
                    binding.TEXT.visibility = View.GONE
                    binding.NUMERIC.visibility = View.GONE
                    binding.LIST.visibility = View.VISIBLE

                    //something sad
                    if (!fieldsList[position].values?.v1.isNullOrEmpty())
                    binding.v1.text = fieldsList[position].values?.v1
                    else binding.v1.visibility = View.GONE

                    //something very sad
                    if (!fieldsList[position].values?.v2.isNullOrEmpty())
                        binding.v2.text = fieldsList[position].values?.v2
                    else binding.v2.visibility = View.GONE

                    // i'm crying
                    if (!fieldsList[position].values?.v3.isNullOrEmpty())
                        binding.v3.text = fieldsList[position].values?.v3
                    else binding.v3.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return fieldsList.size
    }

}