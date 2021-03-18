package com.mobgen.task.di

import com.mobgen.task.domain.repositories.BookRepository
import com.mobgen.task.domain.repositories.CategoryRepository
import com.mobgen.task.domain.repositories.CharRepository
import com.mobgen.task.domain.repositories.HouseRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { CategoryRepository(get()) }
    single { BookRepository(get()) }
    single { HouseRepository(get()) }
    single { CharRepository(get()) }
}