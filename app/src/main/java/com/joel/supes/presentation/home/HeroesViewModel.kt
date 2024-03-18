package com.joel.supes.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.supes.domain.use_case.HeroesUseCase
import com.joel.supes.utils.Resource
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HeroesViewModel(
    private val heroesUseCase: HeroesUseCase
) : ViewModel() {

    private val _state = mutableStateOf(HeroesScreenState())
    val state : State<HeroesScreenState> = _state

    init {
        getHeroes()
    }

    fun getHeroes(){
        viewModelScope.launch {
            heroesUseCase.getHeroesUseCase().onEach {resource ->
                when(resource){
                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = resource.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            loading = true
                        )
                    }
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            heroes = resource.data ?: emptyList()
                        )
                    }
                }
            }
        }
    }
}