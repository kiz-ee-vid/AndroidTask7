package com.example.task_7.presentation.ui.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task_7.data.ApiItem
import com.example.task_7.data.RepositoryImpl
import com.example.task_7.presentation.di.NetworkModule
import kotlinx.coroutines.*

class MainViewModel (context: Context) : ViewModel() {

    var apiForm: MutableLiveData<ApiItem> = MutableLiveData()

    init{
        val repositoryImpl = RepositoryImpl(NetworkModule.provideApiService(NetworkModule.provideRetrofit()))
        CoroutineScope(Dispatchers.Default).launch {
            val api = repositoryImpl.getApiItem()
            withContext(Dispatchers.Main){
                apiForm.value = api
            }
        }
    }
}