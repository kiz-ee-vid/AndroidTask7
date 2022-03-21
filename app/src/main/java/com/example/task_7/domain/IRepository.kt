package com.example.task_7.domain

import com.example.task_7.data.ApiItem
import com.example.task_7.data.model.ApiPost
import com.example.task_7.data.model.ApiResponse

interface IRepository {
    suspend fun getApiItem(): ApiItem?

    suspend fun sendResponse(post: ApiPost): ApiResponse?
}