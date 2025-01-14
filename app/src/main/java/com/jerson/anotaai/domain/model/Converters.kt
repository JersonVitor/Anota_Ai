package com.jerson.anotaai.domain.model

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
class Converters {

    @TypeConverter
    fun fromULong(value: ULong): Long = value.toLong()

    @TypeConverter
    fun toULong(value: Long): ULong = value.toULong()
}