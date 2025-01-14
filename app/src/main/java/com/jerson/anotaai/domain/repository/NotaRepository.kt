package com.jerson.anotaai.domain.repository

import com.jerson.anotaai.domain.model.Nota
import kotlinx.coroutines.flow.Flow

interface NotaRepository{

    suspend fun insertNota(nota: Nota)
    suspend fun updateNota(nota: Nota)
    suspend fun deleteNota(nota: Nota)
    fun getNotas(): Flow<List<Nota>>
    suspend fun deleteListNotes(vararg notas: Nota)

}