package com.mobgen.task.di

import com.mobgen.task.data.network.service.Service
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single(createdAtStart = false) { get<Retrofit>().create(Service::class.java) }
}