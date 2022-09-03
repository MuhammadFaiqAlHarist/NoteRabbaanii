package com.faiq.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import by.kirich1409.viewbindingdelegate.viewBinding
import com.faiq.notesapp.databinding.ActivityMainBinding
import com.faiq.notesapp.entity.network.NotesViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()
    private val notesAdapter by lazy { NotesAdapter() }
    private val viewModel by viewModels<NotesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.apply {
            fab.setOnClickListener {
                val intent = Intent(this@MainActivity, AddNotes::class.java)
                startActivity(intent)
            }
        }


    }
}