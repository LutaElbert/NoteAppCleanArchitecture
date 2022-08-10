package com.personal.cleanarchitecture_noteapp.feature_note.domain.util

import com.personal.cleanarchitecture_noteapp.R

enum class Route(val id: Int) {
    NAVIGATE_FROM_ADDFORM_TO_LIST(R.id.action_noteAddFragment_to_noteListFragment),
    NAVIGATE_FROM_LIST_TO_ADDFORM(R.id.action_noteListFragment_to_noteAddFragment),
}
