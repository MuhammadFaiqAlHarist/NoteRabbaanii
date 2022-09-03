package com.faiq.notesapp.entity.network

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.faiq.notesapp.entity.Notes
import com.faiq.notesapp.entity.NotesRepository
import com.faiq.notesapp.room.NotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private val notesDao = NotesDatabase.getDatabase(application).NotesDao()
    private val repository: NotesRepository = NotesRepository(notesDao)

    fun getAllData(): LiveData<List<Notes>> = repository.allNotes

    fun insertData(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNotes(notes)
        }
    }

    fun deleteNote(notes: Notes) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteNotes(notes)
        }
    }

    fun updateNote(notes: Notes)  {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNotes(notes)
        }
    }
}