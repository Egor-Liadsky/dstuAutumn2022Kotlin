package com.android.app.fragments.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.android.app.databinding.FragmentAddTaskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment : Fragment() {

    private val viewModel: AddTaskViewModel by viewModels()
    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        binding.signInButton.setOnClickListener {
            viewModel.addTask(
                arguments?.getInt("toId"),
                binding.titlePlainText.text.toString(),
                binding.contentPlainText.text.toString(),
                binding.checkBox.isChecked,
                binding.startTimePlainText.text.toString(),
                binding.endTimePlainText.text.toString()
            )
        }

        return binding.root
    }
}