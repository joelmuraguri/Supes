package com.joel.supes.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HeroDao {

    @Query("SELECT * FROM HERO_TABLE")
    fun getAllHeroes() : Flow<List<HeroEntity>>

    @Query("SELECT * FROM Hero_Table WHERE id=:id")
    fun getHeroById(id : Int) : Flow<HeroEntity>

    @Upsert
    suspend fun upsert(heroes : List<HeroEntity>)
}