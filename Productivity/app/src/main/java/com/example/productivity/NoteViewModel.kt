package com.example.productivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application):AndroidViewModel(application) {
    val repositry : NoteRespository
    val notesall :LiveData<List<Note>>
init {


    val getdao = NoteDataBase.getDatabase(application).wordDao()
     repositry = NoteRespository(getdao)
    notesall =repositry.viewall

}
    fun delete (note:Note)= viewModelScope.launch (Dispatchers.IO)
    {
     repositry.delete(note)
    }

    fun insert (note:Note)= viewModelScope.launch (Dispatchers.IO)
    {
        repositry.Insert(note)
    }
}

//api 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0-beta01'
   // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")