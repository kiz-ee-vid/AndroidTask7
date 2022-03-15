package com.example.task_7.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("http://test.clevertec.ru/tt/meta/")
    suspend fun getApiItem(): Response<ApiItem>
}