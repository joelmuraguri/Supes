package com.joel.supes.domain.repository

import com.joel.supes.data.network.api.dtos.HeroesDTOs

interface HeroesRemoteSource {

    suspend fun fetchAllHeroes() : HeroesDTOs

}