package com.personal.cleanarchitecture_noteapp.feature_note.presentation.note_add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.personal.cleanarchitecture_noteapp.R
import com.personal.cleanarchitecture_noteapp.databinding.FragmentNoteAddBinding
import com.personal.cleanarchitecture_noteapp.feature_note.common.Extensions.toPriority
import com.personal.cleanarchitecture_noteapp.feature_note.domain.model.NoteEntity
import com.personal.cleanarchitecture_noteapp.feature_note.domain.util.Route
import com.personal.cleanarchitecture_noteapp.feature_note.presentation.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteAddFragment : Fragment(), MenuProvider {

    private var _binding: FragmentNoteAddBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by viewModels()

    private val viewModel: NoteAddViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteAddBinding.inflate(inflater, container, false)

        setupBinding(binding)
        setupMenu()

        return binding.root
    }

    private fun setupMenu() {
        val provider: MenuHost = requireActivity()
        provider.addMenuProvider(this)
    }

    private fun setupBinding(binding: FragmentNoteAddBinding) {
        binding.apply {
            spinnerPriority.onItemSelectedListener = sharedViewModel.spinnerOnSelectedListener
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_note_add, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.menu_add -> {
                insertToDatabase()
            }
        }
        return true
    }

    private fun insertToDatabase() {
        binding.apply {
            val title = inputTitle.text.toString()
            val priority = spinnerPriority.selectedItem.toString()
            val content = inputContent.text.toString()

            viewModel.onEvent(
                NoteAddEvent.insertNote(
                    NoteEntity(
                        title = title,
                        priority = priority.toPriority(),
                        content = content
                    )
                )
            )

            Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()

            findNavController().navigate(Route.NAVIGATE_FROM_ADDFORM_TO_LIST.id)
        }
    }
}