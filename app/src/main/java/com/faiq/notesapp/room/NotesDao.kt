package com.faiq.notesapp.room

import androidx.room.*
import com.faiq.notesapp.entity.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes_table")
    fun getData() : List<Notes>

    @Delete()
    suspend fun deleteData(note : Notes)

    @Update()
    suspend fun updateNotes(note: Notes)

    @Insert
    suspend fun insertNotes(note: Notes)

    @Query("SELECT * FROM notes_table WHERE id = :notesId")
    suspend fun getDataId(notesId : Int) : Notes

}