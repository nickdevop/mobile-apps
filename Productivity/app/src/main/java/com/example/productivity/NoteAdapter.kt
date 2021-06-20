package com.example.productivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.itemview.view.*

class NoteAdapter(val context:Context,val listner:clickshandling):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    val viewall :ArrayList<Note> = ArrayList()
   inner class NoteViewHolder(view: View):RecyclerView.ViewHolder(view)
    {
        val itemview:TextView =view.findViewById(R.id.textView)
        val deletebutton:ImageView =view.findViewById(R.id.deletebutton)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
val view=LayoutInflater.from(context).inflate(R.layout.itemview,parent,false)
 val noteviewholder=NoteViewHolder(view)
view.deletebutton.setOnClickListener()
{
    listner.onclickhandling(viewall[noteviewholder.adapterPosition])
}
        return noteviewholder
    }
/////////////////////////////////////////////////
fun updatetask(updateNotes:List<Note>)
{
    viewall.clear()
    viewall.addAll(updateNotes)
    notifyDataSetChanged() }

    ///////////////////////////////////////////////////////////////

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentPosition =viewall [position]
        holder.itemview .text= currentPosition.Note }

    override fun getItemCount(): Int {
      return viewall.size

    } }

/////////////////////////////////////////////////////////////////////////

interface clickshandling
{
    fun onclickhandling(item:Note)

}