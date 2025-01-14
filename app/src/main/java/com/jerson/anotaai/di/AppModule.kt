package com.jerson.anotaai.di

import android.app.Application
import androidx.room.Room
import com.jerson.anotaai.data.NotaDao
import com.jerson.anotaai.data.NotaDatabase
import com.jerson.anotaai.data.repository.NotarepositoryImpl
import com.jerson.anotaai.domain.repository.NotaRepository
import com.jerson.anotaai.domain.use_cases.DeleteListNotes
import com.jerson.anotaai.domain.use_cases.DeleteNota
import com.jerson.anotaai.domain.use_cases.GetNotas
import com.jerson.anotaai.domain.use_cases.InsertNota
import com.jerson.anotaai.domain.use_cases.NotaUseCases
import com.jerson.anotaai.domain.use_cases.UpdateNota
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNotaDatabase(
        application: Application
    ): NotaDatabase {
        return Room.databaseBuilder(
            context = application,
            NotaDatabase::class.java,
            name = "notas_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesNotasDao(
        notaDatabase: NotaDatabase
    ): NotaDao = notaDatabase.notaDao

    @Provides
    @Singleton
    fun providesNotaRepository(
        notaDao: NotaDao
    ): NotaRepository {
        return NotarepositoryImpl(notaDao)
    }

    @Provides
    @Singleton
    fun providesNotasUseCases(
        notaRepository: NotaRepository
    ): NotaUseCases = NotaUseCases(
        insertNota = InsertNota(notaRepository),
        updateNota = UpdateNota(notaRepository),
        deleteNota = DeleteNota(notaRepository),
        getNotas = GetNotas(notaRepository),
        deleteListNotes = DeleteListNotes(notaRepository)
    )
}