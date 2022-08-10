package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.personal.cleanarchitecture_noteapp.databinding.FragmentNoteListBinding
import com.personal.cleanarchitecture_noteapp.feature_note.common.Resource
import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Route
import com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_list.adapter.NoteListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteLisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNoteListBinding.inflate(inflater, container, false)

        setupBinding(binding)
        subscribeObservers()

        return binding.root
    }

    private fun subscribeObservers() {
        viewModel.state.observe(viewLifecycleOwner) { data ->
            when(data) {
                is Resource.Success -> {
                    val adapter = NoteListAdapter().also { adapter ->
                        adapter.notes = data.data ?: emptyList()
                    }

                    binding.recyclerNotes.adapter = adapter
                }
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }
        }
        viewModel.onEvent(NoteListEvent.GetNotes)
    }

    private fun setupBinding(binding: FragmentNoteListBinding) {
        binding.apply {
            fabAdd.setOnClickListener {
                findNavController().navigate(Route.NAVIGATE_FROM_LIST_TO_ADDFORM.id)
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}