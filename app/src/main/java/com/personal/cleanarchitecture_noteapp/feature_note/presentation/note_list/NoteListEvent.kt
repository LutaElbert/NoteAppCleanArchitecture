package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list

sealed class NoteListEvent{
    object GetNotes: NoteListEvent()
}