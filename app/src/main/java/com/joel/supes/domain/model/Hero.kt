package com.joel.supes.domain.model

import com.joel.supes.data.network.api.dtos.HeroesDTOs

data class Hero(
    val id : Int,
    val name : String,
    val image : String
)

fun HeroesDTOs.HeroDTO.toHero() : Hero{
    return Hero(
        id = id ?: 0,
        name = name ?: "",
        image = images!!.md ?: ""
    )
}
