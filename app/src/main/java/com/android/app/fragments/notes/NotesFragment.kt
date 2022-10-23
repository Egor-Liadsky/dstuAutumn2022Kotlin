package com.android.app.fragments.notes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.adapters.NoteAdapter
import com.android.app.databinding.FragmentNotesBinding
import com.android.app.models.Note
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private var adapter = NoteAdapter()
    private val viewModel: NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = com.android.app.databinding.FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val data = listOf(
//            Note("Первая заметка", "first test",),
//            Note("Вторая заметка", "second test",),
//            Note("Вторая заметка", "second test",),
//            Note("Вторая заметка", "second test",)
//        )

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
        }
//        viewModel.getNotes()
//        Log.e("API", viewModel.noteList.toString())
//        data.forEach {
//            adapter.addData(it.title, it.description, it.date)
//        }

//        binding.addNote.setOnClickListener {
//            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
//        }
    }
}