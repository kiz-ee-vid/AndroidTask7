package com.example.task_7.data

import com.google.gson.annotations.SerializedName

data class ApiItem(
    @SerializedName("title")
    var title: String?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("fields")
    var fields: List<FieldItem> = arrayListOf()
)

data class FieldItem(
    @SerializedName("title")
    var title: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("values")
    val values: Map<String, String>?
)