package com.personal.cleanarchitecture_noteapp.feature_note.common

import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Priority

object Extensions {
    fun String.toPriority() = when(this) {
        "High Priority" -> Priority.HIGH
        "Medium Priority" -> Priority.MEDIUM
        else -> Priority.LOW
    }

}