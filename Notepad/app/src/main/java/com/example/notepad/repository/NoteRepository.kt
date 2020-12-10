package com.example.notepad.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notepad.dao.NoteDao
import com.example.notepad.database.NotepadRoomDatabase
import com.example.notepad.model.Note

class NoteRepository(context: Context) {
    private val noteDao : NoteDao

    init{
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}