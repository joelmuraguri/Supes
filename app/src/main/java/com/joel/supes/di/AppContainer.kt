package com.joel.supes.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.joel.supes.BuildConfig
import com.joel.supes.data.network.api.HeroesService
import com.joel.supes.data.repository.DefaultHeroesRemoteSource
import com.joel.supes.data.repository.DefaultHeroesRepository
import com.joel.supes.domain.repository.HeroesRemoteSource
import com.joel.supes.domain.repository.HeroesRepository
import com.joel.supes.domain.use_case.GetHeroesUseCase
import com.joel.supes.domain.use_case.HeroesUseCase
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

interface AppContainer {
    val heroesRemoteSource : HeroesRemoteSource
    val heroesRepository : HeroesRepository
    val heroesUseCase : HeroesUseCase
}


class DefaultAppContainer : AppContainer{

    private val supesBaseUrl = "https://akabab.github.io/superhero-api/api/"

    private val json = Json { ignoreUnknownKeys = true }

    private val client : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10L, TimeUnit.SECONDS)
        .writeTimeout(10L, TimeUnit.SECONDS)
        .readTimeout(30L, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(client)
        .baseUrl(supesBaseUrl)
        .build()

    private val retrofitService: HeroesService by lazy {
        retrofit.create(HeroesService::class.java)
    }

    override val heroesRemoteSource: HeroesRemoteSource by lazy {
        DefaultHeroesRemoteSource(retrofitService)
    }
    override val heroesRepository: HeroesRepository by lazy {
        DefaultHeroesRepository(heroesRemoteSource)
    }
    override val heroesUseCase: HeroesUseCase by lazy {
        HeroesUseCase(
            getHeroesUseCase = GetHeroesUseCase(heroesRepository)
        )
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
        return HttpLoggingInterceptor().also {
            it.level = level
        }
    }

}