package com.android.app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.app.databinding.ItemNoteBinding
import com.android.app.models.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteHolder>(){

    private var noteList = mutableListOf<NoteModel>()

    class NoteHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: NoteModel){
            binding.title.text = item.title
            binding.description.text = item.description
            binding.date.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteHolder(inflater)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun addData(list: List<NoteModel>){
        noteList.addAll(list)
        notifyDataSetChanged()
    }
}