package com.joel.supes.data.network.api

import com.joel.supes.data.network.api.dtos.HeroesDTOs
import retrofit2.http.GET

interface HeroesService {

    @GET("all.json")
    suspend fun getAllHeroes() : HeroesDTOs

}