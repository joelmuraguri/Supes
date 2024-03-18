package com.joel.supes.data.repository

import com.joel.supes.data.network.api.HeroesService
import com.joel.supes.data.network.api.dtos.HeroesDTOs
import com.joel.supes.domain.repository.HeroesRemoteSource
import timber.log.Timber

class DefaultHeroesRemoteSource(
    private val service: HeroesService
) : HeroesRemoteSource {

    override suspend fun fetchAllHeroes(): HeroesDTOs {
        Timber.d("RESPONSE", service.getAllHeroes())
        return service.getAllHeroes()
    }
}