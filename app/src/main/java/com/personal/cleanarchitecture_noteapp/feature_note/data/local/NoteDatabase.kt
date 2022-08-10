package com.personal.cleanarchitecture_noteapp.feature_note.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    abstract val dao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }

}