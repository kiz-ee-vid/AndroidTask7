package com.example.task_7.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("http://test.clevertec.ru/tt/meta/")
    suspend fun getApiItem(): Response<ApiItem>

    @POST("http://test.clevertec.ru/tt/data/")
    suspend fun sendResponse(@Body post: ApiPost): Response<ApiResponse>
}