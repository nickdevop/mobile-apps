package com.example.motivation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

 class dataAdapter (val listner:clickListner):RecyclerView.Adapter<ViewHolder>(){
    val items=ArrayList<data>()

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val Views=LayoutInflater.from(parent.context).inflate(R.layout.items_list,parent,false)
         val dataviewHolder=ViewHolder(Views)
         Views.setOnClickListener()
         {
             listner.Onclick(items[dataviewHolder.adapterPosition])
         }
return dataviewHolder
              }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val position=items[position]
         holder.text.text=position.text
         holder.author.text="~~~ "+position.author
//         holder.image.cardBackgroundColor.defaultColor
          }

     override fun getItemCount(): Int {
return items.size
     }

     fun updatedata(updatedata:ArrayList<data>)
     {
         items.clear()
         items.addAll(updatedata)
     notifyDataSetChanged()
     }

 }
class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)
{
val text:TextView=itemview.findViewById(R.id.quots)
    val author:TextView=itemview.findViewById(R.id.name)
//    val image:CardView=itemview.findViewById(R.id.card_view)
}
interface clickListner
{
    fun Onclick(data:data)
    {

    }
}