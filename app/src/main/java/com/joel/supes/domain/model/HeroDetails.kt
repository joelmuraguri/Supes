package com.joel.supes.domain.model

import com.joel.supes.data.network.api.dtos.HeroesDTOs

data class HeroDetails(
    val id : Int,
    val name : String,
    val image : String,
    val motive : String,
    val origin : String,
    val intelligence : Int,
    val combat : Int,
    val power : Int,
    val speed : Int,
    val strength : Int,
    val durability : Int,
    val affiliations : String
)


fun HeroesDTOs.HeroDTO.toHeroDetails() : HeroDetails{
    return HeroDetails(
        id = id ?: 0,
        name = name ?: "",
        image = images!!.lg ?: "",
        motive = biography!!.alignment ?: "",
        origin = biography.placeOfBirth ?: "",
        intelligence = powerStats!!.intelligence ?: 0,
        combat = powerStats.combat ?: 0,
        power = powerStats.power ?: 0,
        speed = powerStats.speed ?: 0,
        strength = powerStats.strength ?: 0,
        durability = powerStats.durability ?: 0,
        affiliations = connections!!.groupAffiliation ?: ""
    )
}