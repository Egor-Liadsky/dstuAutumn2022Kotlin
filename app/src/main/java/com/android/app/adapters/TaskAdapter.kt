package com.android.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.app.databinding.ItemTaskBinding
import com.android.app.models.TaskModel

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    private var taskList = mutableListOf<TaskModel>()

    class TaskHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: TaskModel){
            binding.titleTextView.text = item.title
            binding.contentTextView.text = item.description
            binding.startDateTextView.text = item.startDate
            binding.endDateTextView.text = item.endDate
            binding.fromTextView.text = item.from
            binding.whomTextView.text = item.whom
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskHolder {
        val inflater = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskAdapter.TaskHolder(inflater)
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun addData(list: List<TaskModel>){
        taskList.addAll(list)
        notifyDataSetChanged()
    }

}