package com.example.memessharing

import android.app.DownloadManager
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.textclassifier.TextLinks
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import com.android.volley.toolbox.JsonObjectRequest as JsonObjectRequest

class MainActivity : AppCompatActivity() {
    var currentImageURL:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
request()
    }


       private fun request()
        {

progressBar.visibility=View.VISIBLE
            var queue=Volley.newRequestQueue(this)
            var url="https://meme-api.herokuapp.com/gimme"
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url,null,
                Response.Listener { response ->
                    currentImageURL=response.getString("url")

                Glide.with(this).load(currentImageURL).listener(object:RequestListener<Drawable>
                {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility=View.GONE
                       return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {

                        progressBar.visibility=View.GONE
                        return false
                    }

                }
                ).into(image)

                                   },
                Response.ErrorListener {
Toast.makeText(this,"some wents wrong ",Toast.LENGTH_LONG).show()
                })

// Add the request to the RequestQueue.
            queue.add(jsonObjectRequest)



    }

    fun button1(view: View) {


            var intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,"HEY CHECK THIS AMAZING MEME ..$currentImageURL")
            var chooser=Intent.createChooser(intent,"memes")
            startActivity(chooser)

    }

    fun button2(view: View) {
        request()
    }
}