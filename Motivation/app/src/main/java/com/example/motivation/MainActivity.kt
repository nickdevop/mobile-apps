package com.example.motivation

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), clickListner {
    lateinit var adapter:dataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager=LinearLayoutManager(this)
        binddata()
 adapter= dataAdapter(this)
    recycler.adapter=adapter
    }

    private fun binddata() {

        val url="https://type.fit/api/quotes"
        val jsonArrayRequest= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener
        {

            val store=ArrayList<data>()
            for (i in 0 until it.length()){
val jsonObject=it.getJSONObject(i)
val data=data(
        jsonObject.getString("text"),
        jsonObject.getString("author"))

                store.add(data)
//            Log.d("result","Text"+ store)
            }
            adapter.updatedata(store)
        },
                Response.ErrorListener {
Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
                }
        )


MySingleton.getInstance(this).requestQueue.add(jsonArrayRequest)

    }
    @Override
    override fun Onclick(data:data)
    {

        val intent=Intent(Intent.ACTION_SEND)
        intent.type="text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Hey check this motivational quots by :  ${data.author} "+ "\n"+"------------------------"+
                "\n"+data.text+"\n"+"------------------------")

        val chooser=Intent.createChooser(intent," QUOTES ")
        startActivity(chooser)



    }



}