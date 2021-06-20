package com.example.makingeasy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
search.setOnClickListener()
{
    var url=browse.text.toString()
    if(url.isEmpty())
    {
     AlertDialog.Builder(this)
         .setTitle("Blank Entry")
         .setMessage("Pls Enter Url")
         .setPositiveButton("ok",{Dialog,_-> Dialog.dismiss()})
         .setCancelable(false)
         .show()

    }
    else if(!url.startsWith("http://"))
    {
        AlertDialog.Builder(this)
            .setTitle("Invalid URL")
            .setMessage("Pls Enter url with http://")
            .setPositiveButton("ok",{Dialog,_-> Dialog.dismiss()})
            .setCancelable(false)
            .show()

    }
else {
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}
        psearch.setOnClickListener()
        {
            var phoneno=pno.text.toString()
            if(phoneno.isEmpty())
            {
                AlertDialog.Builder(this)
                    .setTitle("No input Detect")
                    .setMessage("Pls Enter phone no")
                    .setPositiveButton("ok",{Dialog,_-> Dialog.dismiss()})
                    .setCancelable(false)
                    .show()

            }
            else
            {
            var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneno"))
            startActivity(intent)
        }}

sweetmssg.setOnClickListener()
{
    Toast.makeText(this,"thanks for using",Toast.LENGTH_LONG).show()
}




    }
}