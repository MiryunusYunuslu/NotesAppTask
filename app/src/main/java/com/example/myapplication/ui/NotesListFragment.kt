package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.adapter.NotesAdapter
import com.example.myapplication.databinding.FragmentNotesListBinding
import com.example.myapplication.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesListFragment : Fragment() {
    private var _binding: FragmentNotesListBinding? = null
    private val binding: FragmentNotesListBinding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    private val adapter by lazy {
        activity?.applicationContext?.let { NotesAdapter() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        configureRecyclerView()
        configureFabAction()
        initObservers()
        viewModel.getAllNotes()
    }

    private fun configureRecyclerView() {
        NotesAdapter.noteClickedEvent = { note ->
            val action = NotesListFragmentDirections.actionNotesListFragmentToNoteDetailsFragment(
                noteDesc = note.description,
                noteId = note.noteId.toString(),
                noteTitle = note.title
            )

            findNavController().navigate(action)
        }

        binding.rvNotes.adapter = adapter
    }

    private fun initObservers() {
        viewModel.allNotes.observe(viewLifecycleOwner) { notes ->
            adapter?.submitList(notes)
        }
    }

    private fun configureFabAction() = with(binding.fabNewNote) {
        setOnClickListener {
            findNavController().navigate(R.id.action_notesListFragment_to_addNoteFragment)
        }
    }
}