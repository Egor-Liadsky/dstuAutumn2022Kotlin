package com.android.app.fragments.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentAddTaskBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment : Fragment() {

    private val viewModel: AddTaskViewModel by viewModels()
    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)

        val title = binding.titlePlainText.text
        val content = binding.contentPlainText.text
        val startTime = binding.startTimePlainText.text
        val endTime = binding.endTimePlainText.text


        binding.signInButton.setOnClickListener {
            if (title.isNotEmpty() || content.isNotEmpty() || startTime.isNotEmpty() || endTime.isNotEmpty()) {
                viewModel.addTask(
                    arguments?.getInt("toId"),
                    binding.titlePlainText.text.toString(),
                    binding.contentPlainText.text.toString(),
                    binding.checkBox.isChecked,
                    binding.startTimePlainText.text.toString(),
                    binding.endTimePlainText.text.toString()
                )
                findNavController().navigate(R.id.action_addTaskFragment_to_tasksFragment)
            } else {
                Snackbar.make(
                    binding.addTaskFragment, "Некоректные данные", Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }
}