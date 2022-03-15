package com.example.task_7.domain

import com.example.task_7.data.ApiItem
import io.reactivex.Single

interface IRepository {
    suspend fun getApiItem(): ApiItem?
}