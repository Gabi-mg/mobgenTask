package com.mobgen.task

import android.app.Application
import com.mobgen.task.di.*

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application(){
    companion object {
        lateinit var instance: App
            private set
    }
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule,
                useCasesModule
            ))

        }
        instance = this
    }
}