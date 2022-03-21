package com.example.task_7.data

import com.example.task_7.data.model.ApiPost
import com.example.task_7.data.model.ApiResponse
import com.example.task_7.domain.IRepository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService) : IRepository {

    override suspend fun getApiItem(): ApiItem? {
        return apiService.getApiItem().body()
    }

    override suspend fun sendResponse(post: ApiPost): ApiResponse?{
        return apiService.sendResponse(post).body()
    }

}