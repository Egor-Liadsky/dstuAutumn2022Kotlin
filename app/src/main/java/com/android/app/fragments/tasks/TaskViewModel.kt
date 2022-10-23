package com.android.app.fragments.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.app.data.repository.TaskRepository
import com.android.app.models.AllTaskModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    var taskList = kotlin.collections.ArrayList<AllTaskModelItem>()

    suspend fun getAllTasks() {
        viewModelScope.runCatching {
            taskList = taskRepository.getAllTask()
        }
    }
}