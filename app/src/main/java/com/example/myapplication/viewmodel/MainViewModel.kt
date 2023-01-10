package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Note
import com.example.myapplication.repository.LocalRepository
import com.example.myapplication.repository.LocalRepositoryImplementer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: LocalRepositoryImplementer) : ViewModel() {
    val allNotes = MutableLiveData<List<Note>>()

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            val notes = repository.getAllNotes()
            allNotes.postValue(notes)
        }
    }

    fun insertNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }
}