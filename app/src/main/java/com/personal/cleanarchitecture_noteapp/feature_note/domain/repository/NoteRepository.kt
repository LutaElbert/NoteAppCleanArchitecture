package com.personal.cleanarchitecture_noteapp.feature_note.domain.repository

import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity

interface NoteRepository {

    suspend fun insertNote(note: NoteEntity)

    suspend fun updateNote(note: NoteEntity)

    suspend fun deleteNote(note: NoteEntity)

    suspend fun getNotes(): List<NoteEntity>
}