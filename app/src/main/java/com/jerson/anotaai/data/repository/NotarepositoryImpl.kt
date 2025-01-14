package com.jerson.anotaai.data.repository

import com.jerson.anotaai.data.NotaDao
import com.jerson.anotaai.domain.model.Nota
import com.jerson.anotaai.domain.repository.NotaRepository
import kotlinx.coroutines.flow.Flow

class NotarepositoryImpl(
    private val notaDao: NotaDao
): NotaRepository {
    override suspend fun insertNota(nota: Nota) {
        notaDao.insert(nota)
    }

    override suspend fun updateNota(nota: Nota) {
       notaDao.update(nota)
    }

    override suspend fun deleteNota(nota: Nota) {
        notaDao.delete(nota)
    }

    override fun getNotas(): Flow<List<Nota>> {
        return notaDao.getNotas()
    }

    override suspend fun deleteListNotes(vararg notas: Nota) {
        notaDao.deleteListNotes(*notas)
    }

}