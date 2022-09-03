package com.faiq.notesapp.room

import androidx.room.TypeConverter
import com.faiq.notesapp.entity.Priority

class Converter {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(string: String): Priority {
        return Priority.valueOf(string)
    }
}