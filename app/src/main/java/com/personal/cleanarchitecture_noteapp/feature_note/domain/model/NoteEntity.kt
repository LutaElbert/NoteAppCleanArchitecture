package com.personal.cleanarchitecture_noteapp.feature_note.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Priority
import kotlinx.parcelize.Parcelize

@Entity(tableName = "note_table")
@Parcelize
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String,
    var priority: Priority,
    var content: String
): Parcelable {
    fun toNote() = Note(id, title, priority, content)
}

class InvalidNoteException(err: String): Exception(err)