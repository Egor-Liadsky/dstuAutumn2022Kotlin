package com.android.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.app.databinding.ItemTaskBinding
import com.android.app.models.AllTaskModelItem
import com.android.app.models.TaskModel

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    private var taskList =
        kotlin.collections.ArrayList<AllTaskModelItem>()

    class TaskHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: AllTaskModelItem){
            binding.titleTextView.text = item.title
            binding.contentTextView.text = item.text
            binding.startDateTextView.text = "Дата начала: ${item.time_start}"
            binding.endDateTextView.text = "Дата окончания: ${item.time_end}"
            binding.fromTextView.text = "От кого: ${item.from_id.toString()}"
            binding.whomTextView.text = "Кому: ${item.to_id.toString()}"
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

    fun addData(list: List<AllTaskModelItem>){
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

}