package com.joel.supes.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.joel.supes.SupesApp
import com.joel.supes.presentation.home.HeroesViewModel

object ViewModelFactory {

    val Factory = viewModelFactory {
        initializer {
            HeroesViewModel(
                heroesUseCase = supesApplication().container.heroesUseCase
            )
        }
    }
}

fun CreationExtras.supesApplication() : SupesApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as SupesApp)