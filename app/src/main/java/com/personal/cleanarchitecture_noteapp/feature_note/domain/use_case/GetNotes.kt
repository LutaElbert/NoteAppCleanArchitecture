package com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case

import com.personal.cleanarchitecture_noteapp.feature_note.common.Resource
import com.personal.cleanarchitecture_noteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class GetNotes(val repository: NoteRepository) {
    suspend operator fun invoke() = flow {
        try {
            emit(Resource.Loading())
            delay(1000)
            val notes = repository.getNotes().map { it.toNote() }
            emit(Resource.Success(notes))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "GetNotes: Something is wrong"))
        }
    }
}