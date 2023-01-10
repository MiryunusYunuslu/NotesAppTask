package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemNoteBinding
import com.example.myapplication.model.Note

class NotesAdapter : ListAdapter<Note, NotesAdapter.NotesViewHolder>(NotesDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(item)

    }

    fun getNote(position: Int): Note = getItem(position)


    class NotesViewHolder private constructor(val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Note) {
            binding.tvNoteTitle.text = item.title
            binding.tvNoteDesc.text = item.description
            if (binding.tvNoteTitle.text.isBlank())
                binding.tvNoteTitle.visibility = View.GONE
            else
                binding.tvNoteTitle.visibility = View.VISIBLE
        }

        companion object {
            fun from(parent: ViewGroup): NotesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNoteBinding.inflate(layoutInflater, parent, false)
                return NotesViewHolder(binding)
            }
        }
    }
}

class NotesDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.noteId == newItem.noteId
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}