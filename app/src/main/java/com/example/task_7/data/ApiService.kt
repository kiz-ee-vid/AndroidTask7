package com.example.task_7.data

import com.example.task_7.data.model.ApiPost
import com.example.task_7.data.model.ApiResponse
import com.example.task_7.domain.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(Constants.GET_ENDPOINT)
    suspend fun getApiItem(): Response<ApiItem>

    @POST(Constants.POST_ENDPOINT)
    suspend fun sendResponse(@Body post: ApiPost): Response<ApiResponse>
}