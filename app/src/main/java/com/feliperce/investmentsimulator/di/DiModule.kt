package com.feliperce.investmentsimulator.di

import com.feliperce.investmentsimulator.BuildConfig
import com.feliperce.investmentsimulator.data.remote.service.InvestmentService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = module {

    fun retrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.ENDPOINT_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun githubService(retrofit: Retrofit): InvestmentService {
        return retrofit.create(InvestmentService::class.java)
    }

    single { retrofit() }
    single { githubService(get()) }
}

val repositoryModule = module {

}

val viewModelModule = module {

}