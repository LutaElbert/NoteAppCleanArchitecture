package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.personal.cleanarchitecture_noteapp.databinding.NoteItemBinding
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.Note

class NoteListAdapter: RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    var notes = emptyList<Note>()
        set(value) {
            val diffUtil = NoteDiffUtil(field, value)
            val result = DiffUtil.calculateDiff(diffUtil)
            field = value
            result.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.init(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    inner class ViewHolder(val binding: NoteItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun init(note: Note) {
            binding.apply {
                this.note = note
            }
        }
    }
}