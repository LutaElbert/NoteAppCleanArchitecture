package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(val noteUseCases: NoteUseCases): ViewModel() {

    fun onEvent(event: NoteAddEvent) {
        when(event) {
            is NoteAddEvent.insertNote -> {
                viewModelScope.launch {
                    noteUseCases.insertNote(event.note)
                }
            }
        }
    }
}