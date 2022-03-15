package com.example.task_7.presentation.di

import com.example.task_7.domain.utils.Constants
import com.example.task_7.data.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun provideApiService(retrofit: Retrofit): ApiService = retrofit
        .create(ApiService::class.java)

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }
}