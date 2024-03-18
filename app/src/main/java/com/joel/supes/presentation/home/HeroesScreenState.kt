package com.joel.supes.presentation.home

import com.joel.supes.domain.model.Hero

data class HeroesScreenState(
    val heroes : List<Hero> = emptyList(),
    val loading : Boolean = false,
    val error : String = ""
)
