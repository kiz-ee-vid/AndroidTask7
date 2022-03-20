package com.example.task_7.data

import com.google.gson.annotations.SerializedName

data class ApiPost (
    @SerializedName("form")
    var form: Map<String, String?>
)