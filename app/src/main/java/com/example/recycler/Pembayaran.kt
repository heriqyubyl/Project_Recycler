package com.example.recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_pembayaran.*

class Pembayaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)

        supportActionBar!!.setTitle("Pembayaran")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data from intent
        var intent = intent
        val aSepatu     = intent.getStringExtra("pSepatu")
        val aDesc       = intent.getStringExtra("pDesc")
        val aHarga      = intent.getIntExtra("pHarga", 0)
        val aImg        = intent.getIntExtra("pImg",0)
        val atotal      = intent.getIntExtra("total", 0)
        image.setImageResource(aImg)

        val a = findViewById<TextView>(R.id.pembayaran)
        //setText
        a.text ="Nama Sepatu $aSepatu\n" + "$aDesc" + "\n\n Harga Rp.$aHarga"

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}