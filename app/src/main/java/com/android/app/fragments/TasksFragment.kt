package com.android.app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentNotesBinding
import com.android.app.databinding.FragmentTasksBinding
import com.android.app.models.UsersModel


class TasksFragment : Fragment() {

    private lateinit var binding: FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        val listUser = listOf(
            "Egor", "Egor2", "Egor3", "Egor4"
        )


        binding.popupButton.setOnClickListener {
            showPopupMenu(
                binding.popupButton, listUser
            )
        }

        binding.nextAddTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_addTaskFragment)
        }

        return binding.root
    }

    private fun showPopupMenu(view: View, listUser: List<String>) {
        val popup = PopupMenu(view.context, view)
        popup.menu.apply {
            for (i in listUser) {
                add(i).setOnMenuItemClickListener {
                    binding.popupButton.text = i
                    true
                }
            }
        }
        popup.show()
    }
}