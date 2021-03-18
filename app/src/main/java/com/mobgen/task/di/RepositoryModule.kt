package com.mobgen.task.di

import com.mobgen.task.domain.repositories.CategoryRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CategoryRepository(get()) }
}