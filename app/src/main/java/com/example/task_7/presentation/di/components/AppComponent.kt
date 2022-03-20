package com.example.task_7.presentation.di.components


import com.example.task_7.presentation.di.modules.ModuleViewModel
import com.example.task_7.presentation.di.modules.ReposModule
import com.example.task_7.presentation.ui.MainActivity
import dagger.Component

@Component(modules = [ReposModule::class, ModuleViewModel::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}