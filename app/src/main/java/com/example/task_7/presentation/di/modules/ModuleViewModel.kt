package com.example.task_7.presentation.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.task_7.presentation.di.ViewModelKey
import com.example.task_7.presentation.ui.vm.MainViewModel
import com.example.task_7.presentation.ui.vm.MainViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ModuleViewModel {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory
}
