package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.cleanarchitecture_noteapp.feature_note.common.Resource
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.Note
import com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteLisViewModel @Inject constructor(private val noteUseCases: NoteUseCases): ViewModel() {

    private val _state: MutableLiveData<Resource<List<Note>>> = MutableLiveData()
    val state get() = _state

    fun onEvent(event: NoteListEvent) {
        when(event) {
            is NoteListEvent.GetNotes -> {
                viewModelScope.launch(Dispatchers.IO) {
                    noteUseCases.getNotes()
                        .map { _state.value = it }
                        .launchIn(viewModelScope)
                }
            }
        }
    }
}