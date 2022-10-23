package com.android.app.fragments.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.app.R
import com.android.app.adapters.TaskAdapter
import com.android.app.databinding.FragmentTasksBinding
import com.android.app.models.Task
import com.android.app.models.TaskModel
import com.android.app.models.UsersItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment() {

    //    private val vModel: AddTaskViewModel by viewModels()
    private lateinit var binding: FragmentTasksBinding
    private var adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        val listData = listOf<TaskModel>(
            TaskModel("wd", "qwkej", ";kasjdf", "dkasjdqw", "klfjsd", "qwkej"),
            TaskModel ("wd", "qwkej", ";kasjdf", "dkasjdqw", "klfjsd", "qwkej"),
            TaskModel("wd", "qwkej", ";kasjdf", "dkasjdqw", "klfjsd", "qwkej")
        )

        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = adapter

//        for (i in listData){
//            adapter.addData(i)
//        }

        adapter.addData(listData)


        binding.createTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_selectUserTaskFragment)
        }

        return binding.root
    }


}