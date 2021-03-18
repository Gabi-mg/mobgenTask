package com.mobgen.task.di


import com.mobgen.task.app.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    //viewModel { HomeViewModel(get()) }
//    viewModel { SlideshowViewModel() }
}