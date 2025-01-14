package com.jerson.anotaai.presentation.screens.detailsNota

import androidx.compose.ui.graphics.Color

sealed class DetalhesNotaEvent {
    data object UpdateNota : DetalhesNotaEvent()
    data object ModoEdicao: DetalhesNotaEvent()
    data object DeleteNota : DetalhesNotaEvent()

    data class AtualizarTitulo(val titulo: String): DetalhesNotaEvent()
    data class AtualizarTexto(val conteudo: String): DetalhesNotaEvent()
    data class UpdateColor(val color: Color): DetalhesNotaEvent()


}
