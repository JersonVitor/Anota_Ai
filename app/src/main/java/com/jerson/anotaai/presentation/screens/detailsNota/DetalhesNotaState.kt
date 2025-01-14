package com.jerson.anotaai.presentation.screens.detailsNota

import com.jerson.anotaai.domain.model.Nota

data class DetalhesNotaState(
    var edit : Boolean = false,
    var nota: Nota = Nota()
)
