package com.example.task_7.data

import com.example.task_7.domain.IRepository
import io.reactivex.Single

class RepositoryImpl (private val apiService: ApiService) : IRepository {

    override suspend fun getApiItem(): ApiItem? {
        return apiService.getApiItem().body()
    }

}