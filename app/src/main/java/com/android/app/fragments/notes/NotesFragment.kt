package com.android.app.fragments.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.adapters.NoteAdapter
import com.android.app.databinding.FragmentNotesBinding
import com.android.app.models.Note


class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private var adapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = com.android.app.databinding.FragmentNotesBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            Note("TEst", "first test", "10.12.2001"),
            Note("TEst2", "second test", "10.12.2006")
        )

        binding.createNoteButton.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
        }

        data.forEach {
//            adapter.addData(it.title, it.description, it.date)
        }

//        binding.addNote.setOnClickListener {
//            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
//        }
    }
}