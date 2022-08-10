package com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case

data class NoteUseCases(
    val insertNote: InsertNote,
    val updateNote: UpdateNote,
    val deleteNote: DeleteNote,
    val getNotes: GetNotes
)