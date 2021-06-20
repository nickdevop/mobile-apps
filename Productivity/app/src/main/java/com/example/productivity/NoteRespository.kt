package com.example.productivity

import androidx.lifecycle.LiveData
import androidx.room.Delete

class NoteRespository(val notedao:Notedao) {
    val viewall:LiveData<List<Note>> =notedao.showall()
    suspend fun Insert(note:Note){
        notedao.insert(note)
    }
    suspend fun delete(note:Note){
        notedao.delete(note)
    }

}