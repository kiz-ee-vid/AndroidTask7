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
    val values: Values?
)

data class Values (
    @SerializedName("none")
    val none: String,
    @SerializedName("v1")
    val v1: String,
    @SerializedName("v2")
    val v2: String,
    @SerializedName("v3")
    val v3: String
)