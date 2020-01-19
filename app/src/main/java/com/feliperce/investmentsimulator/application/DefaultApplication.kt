package com.feliperce.investmentsimulator.application

import android.app.Application
import com.feliperce.investmentsimulator.di.repositoryModule
import com.feliperce.investmentsimulator.di.retrofitModule
import com.feliperce.investmentsimulator.di.viewModelModule
import org.koin.core.context.startKoin

class DefaultApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(arrayListOf(
                retrofitModule,
                repositoryModule,
                viewModelModule
            ))
        }
    }
}