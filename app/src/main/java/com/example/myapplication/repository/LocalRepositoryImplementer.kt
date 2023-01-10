package com.example.myapplication.repository

import com.example.myapplication.db.NoteDao
import com.example.myapplication.model.Note
import javax.inject.Inject

class LocalRepositoryImplementer @Inject constructor(private val noteDao: NoteDao) :
    LocalRepository {

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)
    override suspend fun getAllNotes() = noteDao.getAllNotes()
}