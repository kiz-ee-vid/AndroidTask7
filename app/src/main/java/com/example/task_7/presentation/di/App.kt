package com.example.task_7.presentation.di

import android.app.Application
import com.example.task_7.presentation.di.components.AppComponent
import com.example.task_7.presentation.di.components.DaggerAppComponent

class App: Application() {

     private val component by lazy { DaggerAppComponent.create() }

     fun getAppComponent(): AppComponent = component
}