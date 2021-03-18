package com.mobgen.task.di

import com.mobgen.task.domain.usecases.CategoryUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { CategoryUseCase(get()) }
}

