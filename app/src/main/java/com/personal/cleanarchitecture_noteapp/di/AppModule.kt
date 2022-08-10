package com.personal.cleanarchitecture_noteapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.Update
import com.personal.cleanarchitecture_noteapp.feature_note.data.local.NoteDatabase
import com.personal.cleanarchitecture_noteapp.feature_note.data.repository.NoteRepositoryImpl
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.Note
import com.personal.cleanarchitecture_noteapp.feature_note.domain.repository.NoteRepository
import com.personal.cleanarchitecture_noteapp.feature_note.domain.use_case.*
import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Priority
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun providesNoteRepository(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDatabase.dao)
    }

    @Provides
    fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            insertNote = InsertNote(repository),
            updateNote = UpdateNote(repository),
            deleteNote = DeleteNote(repository),
            getNotes = GetNotes(repository)
        )
    }

    @Provides
    fun provideNote() = Note(0,"",Priority.HIGH,"")
}