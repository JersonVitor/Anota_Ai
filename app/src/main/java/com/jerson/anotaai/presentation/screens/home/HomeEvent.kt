package com.jerson.anotaai.presentation.screens.home

sealed class HomeEvent {
    data object LoadChecable : HomeEvent()
    data object DeleteNotes : HomeEvent()
}