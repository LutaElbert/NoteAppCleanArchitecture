package com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case

import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity
import com.personal.cleanarchitecture_noteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(val repository: NoteRepository) {
    suspend operator fun invoke(note: NoteEntity) {
        repository.deleteNote(note)
    }
}