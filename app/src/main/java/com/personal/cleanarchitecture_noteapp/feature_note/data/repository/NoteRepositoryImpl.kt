package com.personal.cleanarchitecture_noteapp.feature_note.data.repository

import com.personal.cleanarchitecture_noteapp.feature_note.data.local.NoteDao
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity
import com.personal.cleanarchitecture_noteapp.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl(val dao: NoteDao): NoteRepository {

    override suspend fun insertNote(note: NoteEntity) {
        dao.insertNote(note)
    }

    override suspend fun updateNote(note: NoteEntity) {
        dao.updateNote(note)
    }

    override suspend fun deleteNote(note: NoteEntity) {
        dao.deleteNote(note)
    }

    override suspend fun getNotes(): List<NoteEntity> {
        return dao.getNotes()
    }
}