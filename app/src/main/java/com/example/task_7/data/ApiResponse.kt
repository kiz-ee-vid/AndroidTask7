package com.example.task_7.data

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("result")
    var result: String
)