package com.personal.cleanarchitecture_noteapp.feature_note.presentation

import android.app.Application
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel

class SharedViewModel(application: Application): AndroidViewModel(application) {

    val spinnerOnSelectedListener: AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when(p2) {
                0 -> (p0?.getChildAt(0) as TextView).setTextColor(
                    ContextCompat.getColor(application,
                    android.R.color.holo_red_dark))
                1 -> (p0?.getChildAt(0) as TextView).setTextColor(
                    ContextCompat.getColor(application,
                        android.R.color.holo_orange_dark))
                2 -> (p0?.getChildAt(0) as TextView).setTextColor(
                    ContextCompat.getColor(application,
                        android.R.color.holo_green_dark))
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {}
    }
}