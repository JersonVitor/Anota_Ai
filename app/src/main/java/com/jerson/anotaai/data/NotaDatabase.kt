package com.jerson.anotaai.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jerson.anotaai.domain.model.Nota


@Database(entities = [Nota::class], version = 1, exportSchema = false)
//@TypeConverters(Converters::class)
abstract class NotaDatabase : RoomDatabase(){
    abstract val notaDao: NotaDao
}