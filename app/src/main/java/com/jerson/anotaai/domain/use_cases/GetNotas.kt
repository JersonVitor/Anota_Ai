package com.jerson.anotaai.domain.use_cases

import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.repository.NotaRepository
import kotlinx.coroutines.flow.Flow

class GetNotas(
    private val notaRepository: NotaRepository
) {
    operator fun invoke(): Flow<List<Nota>>{
        return notaRepository.getNotas()
    }
}