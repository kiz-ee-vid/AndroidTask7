package com.example.task_7.presentation

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_7.data.FieldItem
import com.example.task_7.domain.utils.Constants
import android.widget.RadioButton
import com.example.task_7.R
import com.example.task_7.databinding.ListEditBinding
import com.example.task_7.databinding.NumericEditBinding
import com.example.task_7.databinding.StringEditBinding


class RecyclerAdapter(var fieldsList: List<FieldItem>, val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val map = mutableMapOf<String, String>()
    inner class StringHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = StringEditBinding.bind(itemView)
        fun bind(item: FieldItem) {
            map[item.name.toString()] = ""
            binding.textView.text = item.title
            binding.TEXT.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    map[item.name.toString()] = binding.TEXT.text.toString()
                }
                override fun afterTextChanged(p0: Editable?) {
                }
            })
        }
    }

    inner class NumericHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = NumericEditBinding.bind(itemView)
        fun bind(item: FieldItem) {
            map[item.name.toString()] = ""
            binding.textView.text = item.title
            binding.NUMERIC.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    val value = if (!p0.toString().contains('.'))
                        p0.toString() + ".0" else p0.toString()
                    map[item.name.toString()] = value
                }
                override fun afterTextChanged(p0: Editable?) {
                }
            })
        }
    }

    inner class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListEditBinding.bind(itemView)
        fun bind(item: FieldItem) {
            binding.textView.text = item.title
            var checked = false
            item.values?.forEach {
                if (it.key != "none") {
                    val radioButton = RadioButton(binding.root.context)
                    radioButton.text = it.value
                    radioButton.tag = it.key
                    binding.LIST.addView(radioButton)
                }
                else{
                    map[item.name.toString()] = it.key
                    checked = true
                }
            }
            binding.LIST.setOnCheckedChangeListener { radioGroup, i ->
                map[item.name.toString()] = radioGroup.findViewById<RadioButton>(i).tag.toString()
            }
            if (!checked){
                binding.LIST.check(binding.LIST.getChildAt(0).id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> StringHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.string_edit, parent, false)
            )
            2 -> NumericHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.numeric_edit, parent, false)
            )
            else -> ListHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_edit, parent, false)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (fieldsList[position].type) {
            Constants.TEXT -> 1
            Constants.NUMERIC -> 2
            else -> 3
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (fieldsList[position].type) {
            Constants.TEXT -> (holder as StringHolder).bind(fieldsList[position])
            Constants.NUMERIC -> (holder as NumericHolder).bind(fieldsList[position])
            else -> (holder as ListHolder).bind(fieldsList[position])
        }
    }

    override fun getItemCount(): Int {
        return fieldsList.size
    }
}