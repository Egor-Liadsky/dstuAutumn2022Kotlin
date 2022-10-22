package com.android.app.fragments.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.databinding.FragmentTasksBinding
import com.android.app.models.UsersItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment() {

    private val vModel: AddTaskViewModel by viewModels()
    private lateinit var binding: FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)


        binding.popupButton.setOnClickListener {
            vModel.getAllUsers()
            showPopupMenu(
                binding.popupButton, vModel.listUsers
            )
        }

        binding.nextAddTaskButton.setOnClickListener {
            if (vModel.toId != 0)
                findNavController().navigate(
                    R.id.action_tasksFragment_to_addTaskFragment,
                    bundleOf("toid" to vModel.toId)
                )
        }

        return binding.root
    }

    private fun showPopupMenu(view: View, listUser: ArrayList<UsersItem>) {
        var a = ""
        val b = 1
        val popup = PopupMenu(view.context, view)
        popup.menu.apply {
            for (i in listUser) {
                a = i.public_name
                add(a).setOnMenuItemClickListener {
                    binding.popupButton.text = a
                    vModel.toId = i.user_id
                    true
                }
            }
        }
        popup.show()
    }
}