package com.android.app.fragments.tasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.app.R
import com.android.app.data.repository.UserRepository
import com.android.app.databinding.FragmentSelectUserTaskBinding
import com.android.app.databinding.FragmentTasksBinding
import com.android.app.models.UsersItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectUserTaskFragment : Fragment() {
    private lateinit var binding: FragmentSelectUserTaskBinding
    private val viewModel: SelectUserTaskFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectUserTaskBinding.inflate(inflater, container, false)
        val listName = listOf("ewg", "akjshd", "1i23u")

        binding.popupButton.setOnClickListener {
            viewModel.getAllUsers()
            showPopupMenu(
                binding.popupButton, viewModel.listUsers
            )
        }


        binding.nextAddTaskButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_selectUserTaskFragment_to_addTaskFragment,
                bundleOf("asd" to binding.popupButton.text)
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
                    binding.popupButton.text = i.public_name
                    viewModel.toId = i.user_id
                    true
                }
            }
        }
        popup.show()
    }
}