package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentNoteDetailsBinding
import com.example.myapplication.model.Note
import com.example.myapplication.viewmodel.MainViewModel


class NoteDetailsFragment : Fragment() {
    private var _binding: FragmentNoteDetailsBinding? = null
    private val binding: FragmentNoteDetailsBinding get() = _binding!!

    private val args: NoteDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureTexts()
    }

    private fun configureTexts() = with(binding) {
        tvNoteDesc.text = args.noteDesc
        tvNoteId.text = args.noteId
        tvNoteTitle.text = args.noteTitle
    }
}