package com.example.task_7.presentation.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task_7.data.ApiItem
import com.example.task_7.data.ApiPost
import com.example.task_7.data.ApiResponse
import com.example.task_7.data.RepositoryImpl
import kotlinx.coroutines.*
import javax.inject.Inject

class MainViewModel @Inject constructor (private val repositoryImpl: RepositoryImpl) : ViewModel() {

    var apiForm: MutableLiveData<ApiItem> = MutableLiveData()
    init{
        getData()
    }

    private fun getData(){
            CoroutineScope(Dispatchers.Default).launch {
                val api = repositoryImpl.getApiItem()
                withContext(Dispatchers.Main) {
                    apiForm.value = api
                }
            }
    }

    fun sendPost(map: Map<String, String>, dialogShow: (ApiResponse) -> Unit) {
        CoroutineScope(Dispatchers.Default).launch {
            val apiSend = ApiPost(map)
            val response = repositoryImpl.sendResponse(apiSend)
            withContext(Dispatchers.Main){
                if (response != null) {
                    dialogShow(response)
                }
            }
        }
    }
}