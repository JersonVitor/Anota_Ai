package com.jerson.anotaai.domain.use_cases

import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.repository.NotaRepository

class DeleteNota (
    private val notaRepository: NotaRepository
){
    suspend operator fun invoke(nota: Nota){
        notaRepository.deleteNota(nota)
    }
}