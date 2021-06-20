package com.example.productivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), clickshandling {
    lateinit var viewmodel: NoteViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.layoutManager =LinearLayoutManager(this)
        val adapter=NoteAdapter(this,this)
        recyclerview.adapter=adapter

        // viewmodel

    viewmodel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))
        .get(NoteViewModel::class.java)
        viewmodel.notesall.observe(this, Observer {list->
            list?.let {
                adapter.updatetask(it)
            }
        })
    }

    fun buttonadd(view: View) {
        val inputtext=task.text.toString()
        if(inputtext.isNotEmpty())
        {viewmodel.insert(Note(inputtext))
            Toast.makeText(this,"$inputtext Task added ",Toast.LENGTH_SHORT).show()

    }
    else
        {
            Toast.makeText(this," Not Enter Any Task  ",Toast.LENGTH_SHORT).show()

        }}

    override fun onclickhandling(item: Note) {

        viewmodel.delete(item)
        Toast.makeText(this,"${item.Note}  Task deleted ",Toast.LENGTH_SHORT).show()
    }

}