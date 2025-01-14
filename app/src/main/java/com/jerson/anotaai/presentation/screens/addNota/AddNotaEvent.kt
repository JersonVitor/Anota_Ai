package com.jerson.anotaai.presentation.screens.addNota

import androidx.compose.ui.graphics.Color

sealed class AddNotaEvent {
    data object InsertNota : AddNotaEvent()
    data class UpdateColor(val color: Color): AddNotaEvent()
    data class AtualizarTitulo(val titulo: String): AddNotaEvent()
    data class AtualizarTexto(val conteudo: String): AddNotaEvent()
}