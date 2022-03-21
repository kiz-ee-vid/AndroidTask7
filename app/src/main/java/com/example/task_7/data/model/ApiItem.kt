package com.example.task_7.data

data class ApiItem(
    var title: String,
    var image: String,
    var fields: List<FieldItem> = arrayListOf()
)

data class FieldItem(
    var title: String,
    var name: String,
    var type: String,
    val values: Map<String, String>?
)