package com.example.myapplication.repository

import com.example.myapplication.model.Note

interface LocalRepository  {
    suspend fun insertNote(note: Note)
    suspend fun getAllNotes():List<Note>
}