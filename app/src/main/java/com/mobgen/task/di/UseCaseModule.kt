package com.mobgen.task.di

import com.mobgen.task.domain.usecases.BookUseCase
import com.mobgen.task.domain.usecases.CategoryUseCase
import com.mobgen.task.domain.usecases.CharUseCase
import com.mobgen.task.domain.usecases.HouseUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { CategoryUseCase(get()) }
    single { BookUseCase(get()) }
    single { HouseUseCase(get()) }
    single { CharUseCase(get()) }
}

