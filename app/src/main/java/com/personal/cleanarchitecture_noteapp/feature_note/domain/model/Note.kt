package com.personal.cleanarchitecture_noteapp.feature_note.domain.model

import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Priority

data class Note(
    var id: Int,
    var title: String,
    var priority: Priority,
    var content: String
) {
    fun toNoteEntity() = NoteEntity(id, title, priority, content)
}