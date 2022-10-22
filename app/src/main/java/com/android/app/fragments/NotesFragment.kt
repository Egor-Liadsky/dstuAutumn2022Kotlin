package com.android.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.adapters.NoteAdapter
import com.android.app.databinding.FragmentLoginBinding
import com.android.app.databinding.FragmentNotesBinding
import com.android.app.models.NoteModel


class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding
    private var adapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        binding = FragmentNotesBinding.inflate(inflater, container, false)

        binding.noteRecyclerView.adapter = adapter


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = listOf(
            NoteModel("TEst", "first test", "10.12.2001"),
            NoteModel("TEst2", "second test", "10.12.2006")
        )

        data.forEach {
//            adapter.addData(it.title, it.description, it.date)
        }
        adapter.addData(data)

//        binding.addNote.setOnClickListener {
//            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
//        }
    }
}