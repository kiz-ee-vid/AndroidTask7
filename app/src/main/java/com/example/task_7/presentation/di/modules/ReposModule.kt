package com.example.task_7.presentation.di.modules

import com.example.task_7.data.ApiService
import com.example.task_7.data.RepositoryImpl
import com.example.task_7.domain.IRepository
import com.example.task_7.presentation.di.modules.NetworkModule
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
object ReposModule {
    @Provides
    fun provideRepository(apiService: ApiService): IRepository =
        RepositoryImpl(apiService)
}