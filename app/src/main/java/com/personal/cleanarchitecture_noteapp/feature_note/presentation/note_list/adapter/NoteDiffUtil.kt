package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.Note

class NoteDiffUtil(val oldList: List<Note>, val newList: List<Note>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList == newList
    }
}