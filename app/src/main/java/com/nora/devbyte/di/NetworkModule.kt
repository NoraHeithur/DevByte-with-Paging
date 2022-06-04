package com.nora.devbyte.di

import com.nora.devbyte.data.network.service.DevByteService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://devbytes.udacity.com/"

val networkModule = module {
    single { Retrofit.Builder() }
    single {
        get<Retrofit.Builder>()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    single { get<Retrofit>().create(DevByteService::class.java) }
}