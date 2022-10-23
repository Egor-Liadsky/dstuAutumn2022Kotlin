package com.android.app.fragments.tasks

import android.os.Bundle
import android.util.Log
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
import com.android.app.models.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class TasksFragment : Fragment() {

    //    private val vModel: AddTaskViewModel by viewModels()
    private lateinit var binding: FragmentTasksBinding
    private var adapter = TaskAdapter()
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)



        runBlocking { viewModel.getAllTasks() }
        Log.e("API", viewModel.taskList.toString())

        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = adapter

        runBlocking { viewModel.getAllTasks() }

        binding.floatingActionButtonTask.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_selectUserTaskFragment)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listData = listOf<AllTaskModelItem>(
            AllTaskModelItem(
                3,
                false,
                24102022,
                21102022,
                6,
                text = "Тестовое содержимое задачи",
                time_start = "15:30",
                time_end = "17:40",
                title = "Первая задача",
                to_id = 2
            ),
            AllTaskModelItem(
                3,
                false,
                11122010,
                21102022,
                7,
                text = "Тест",
                time_start = "02:05",
                time_end = "14:40",
                title = "Вторая задача",
                to_id = 1
            ),
            AllTaskModelItem(
                3,
                false,
                11122010,
                21102022,
                8,
                text = "Тестовые данные",
                time_start = "13:25",
                time_end = "19:00",
                title = "Третья задача",
                to_id = 2
            )
        )
        for (i in listData) {
            adapter.addData(listData)
        }
    }
}