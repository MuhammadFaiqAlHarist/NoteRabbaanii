package com.faiq.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.faiq.notesapp.databinding.ActivityAddNotesBinding
import com.faiq.notesapp.entity.Notes
import com.faiq.notesapp.entity.network.NotesViewModel

class AddNotes : AppCompatActivity() {

    private val binding: ActivityAddNotesBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        val viewModels by viewModels<NotesViewModel>()

        binding.apply {
            btnAdd.setOnClickListener {
                val nTItle = etJudul.text.toString()
                val nDesc = etDeskripsi.text.toString()
                val nPriority = spinnerPriorities.selectedItem.toString()

                val newNote = Notes(0, nTItle, nDesc)
                viewModels.insertData(newNote)
                Toast.makeText(applicationContext, "SUCCESS", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        }
    }
}