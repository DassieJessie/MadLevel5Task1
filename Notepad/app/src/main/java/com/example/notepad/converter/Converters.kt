package com.example.notepad.converter

import androidx.room.TypeConverter
import java.util.*

/**
 * Room cannot store object references in the database. For this reason TypeConverters exist.
 * They convert an object type into a type that can be stored in the database
 * (String, Int, Long etc.).
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
