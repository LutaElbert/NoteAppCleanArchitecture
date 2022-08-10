package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_add

import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity

sealed class NoteAddEvent() {
    data class insertNote(var note: NoteEntity): NoteAddEvent()
}
