package com.example.task_7.presentation.di.modules

import com.example.task_7.data.ApiService
import com.example.task_7.domain.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit
        .create(ApiService::class.java)

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }
}