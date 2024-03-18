package com.joel.supes.data.repository

import com.joel.supes.data.network.api.dtos.HeroesDTOs
import com.joel.supes.domain.repository.HeroesRemoteSource
import com.joel.supes.domain.repository.HeroesRepository
import timber.log.Timber

class DefaultHeroesRepository(
    private val remoteSource: HeroesRemoteSource
) : HeroesRepository {

    override suspend fun fetchAllHeroes(): HeroesDTOs {
        Timber.d("REPO RESPONSE::", remoteSource.fetchAllHeroes())
        return remoteSource.fetchAllHeroes()
    }
}