package com.joel.supes.data.network.api.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeroesDTOs(
    val heroes : List<HeroDTO> = emptyList()
) {

    @Serializable
    data class HeroDTO(
        val appearance: Appearance ?= null,
        val biography: Biography ?= null,
        val connections: Connections ?= null,
        val id: Int ?= null,
        val images: Images ?= null,
        val name: String ?= null,
        @SerialName("powerstats")
        val powerStats: PowerStats ?= null,
        val slug: String ?= null,
        val work: Work ?= null
    ) {

        @Serializable
        data class Appearance(
            val eyeColor: String ?= null,
            val gender: String ?= null,
            val hairColor: String ?= null,
            val height: List<String> = emptyList(),
            val race: String ? = null,
            val weight: List<String> = emptyList()
        )

        @Serializable
        data class Biography(
            val aliases: List<String> = emptyList(),
            val alignment: String ?= null,
            val alterEgos: String ?= null,
            val firstAppearance: String ?= null,
            val fullName: String ?= null,
            val placeOfBirth: String ?= null,
            val publisher: String ?= null
        )

        @Serializable
        data class Connections(
            val groupAffiliation: String ?= null,
            val relatives: String ?= null
        )

        @Serializable
        data class Images(
            val lg: String ?= null,
            val md: String ?= null,
            val sm: String ?= null,
            val xs: String ?= null
        )

        @Serializable
        data class PowerStats(
            val combat: Int ?= null,
            val durability: Int ?= null,
            val intelligence: Int ?= null,
            val power: Int ?= null,
            val speed: Int ?= null,
            val strength: Int ?= null
        )

        @Serializable
        data class Work(
            val base: String ?= null,
            val occupation: String ?= null
        )
    }

}