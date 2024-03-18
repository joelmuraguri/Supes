package com.joel.supes.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Hero_Table")
data class HeroEntity(
    @PrimaryKey val id : Int,
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
