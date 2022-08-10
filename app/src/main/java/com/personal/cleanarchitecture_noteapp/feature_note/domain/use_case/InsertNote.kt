package com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case

import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.InvalidNoteException
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity
import com.personal.cleanarchitecture_noteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class InsertNote(val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: NoteEntity) {
        if(note.title.isBlank() || note.content.isBlank())
            throw InvalidNoteException("Fields must be filled")

        repository.insertNote(note)
    }
}