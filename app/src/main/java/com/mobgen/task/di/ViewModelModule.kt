package com.mobgen.task.di


import com.mobgen.task.app.ui.books.BookViewModel
import com.mobgen.task.app.ui.home.HomeViewModel
import com.mobgen.task.app.ui.SplashViewModel
import com.mobgen.task.app.ui.characters.CharViewModel
import com.mobgen.task.app.ui.house.HouseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { HomeViewModel() }
    viewModel { BookViewModel(get()) }
    viewModel { HouseViewModel(get()) }
    viewModel { CharViewModel(get()) }
}