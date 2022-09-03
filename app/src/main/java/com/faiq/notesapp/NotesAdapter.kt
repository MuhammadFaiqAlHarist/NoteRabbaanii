package com.faiq.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.faiq.notesapp.databinding.RowItemJudulBinding
import com.faiq.notesapp.entity.Notes
import kotlin.time.measureTimedValue

class NotesAdapter() : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: RowItemJudulBinding by viewBinding()
    }

    var allNotes = emptyList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_judul, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = allNotes[position]
        holder.binding.apply {
            textViewTitle.text = note.title
            textViewDescription.text = note.description
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun setData(notes : List<Notes>){
        this.allNotes = notes
        notifyDataSetChanged()
    }
}