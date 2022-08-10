package com.personal.cleanarchitecture_noteapp.feature_note.data.local

import androidx.room.*
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM note_table")
    suspend fun getNotes(): List<NoteEntity>
}