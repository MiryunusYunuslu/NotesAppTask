package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var noteId: Int = 0,
    var title: String,
    var description: String
) : Serializable