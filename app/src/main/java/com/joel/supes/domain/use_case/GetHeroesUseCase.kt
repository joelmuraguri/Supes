package com.joel.supes.domain.use_case

import com.joel.supes.domain.model.Hero
import com.joel.supes.domain.model.toHero
import com.joel.supes.domain.repository.HeroesRepository
import com.joel.supes.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetHeroesUseCase(
    private val heroesRepository: HeroesRepository
) {

    operator fun invoke() : Flow<Resource<List<Hero>>> = flow {
        try {
            emit(Resource.Loading())
            val heroesResponse = heroesRepository.fetchAllHeroes()
            val heroes = heroesResponse.heroes.map { it.toHero()}
            emit(Resource.Success(heroes))
        }
        catch(e : IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
        catch (e : HttpException){
            emit(Resource.Error("FATAL EXCEPTION: Target Server disagree with how request was formatted"))
        }
    }
}