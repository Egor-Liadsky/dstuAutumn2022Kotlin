package com.android.app.fragments.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.app.R
import com.android.app.databinding.FragmentAddNoteBinding
import com.android.app.databinding.FragmentAddTaskBinding
import com.android.app.databinding.FragmentRegistrationBinding
import com.android.app.databinding.FragmentTasksBinding


class AddTaskFragment : Fragment() {
    private lateinit var binding: FragmentAddTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dataButton
    }
}