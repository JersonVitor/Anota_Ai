package com.jerson.anotaai.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.jerson.anotaai.domain.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(nota: Nota)

    @Update
    suspend fun update(nota: Nota)

    @Delete
    suspend fun delete(nota: Nota)

    @Delete
    suspend fun deleteListNotes(vararg notas: Nota)

    @Query("SELECT * FROM Nota")
    fun getNotas(): Flow<List<Nota>>

}