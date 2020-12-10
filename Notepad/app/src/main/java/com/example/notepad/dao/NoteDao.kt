package com.example.notepad.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.notepad.model.Note

@Dao
interface NoteDao {

    /**
     * livedata already runs in a background thread so we don't need coroutines (suspend)
     *
     * LiveData is an observable data holder class. Whenever the data this class is holding is
     * changed the observers will be notified.
     */
    @Query("SELECT * FROM NoteTable LIMIT 1") // LIMIT 1 = geeft maar 1 note van de database
    fun getNotepad(): LiveData<Note?>

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)
}