package com.example.recycler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_pembayaran.*

class OrderActivity : AppCompatActivity() {

    var toHarga     :Int = 0
    var minteger   :Int = 0
    var MIN_NUMBER  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val aSepatu = intent.getStringExtra("pSepatu")
        val aDesc = intent.getStringExtra("pDesc")
        val aHarga = intent.getIntExtra("pHarga", 0)
        val aImg = intent.getIntExtra("pImg", 0)

        actionBar.setTitle("Order" + aSepatu)
        SepatuOrd.text = aSepatu
        descOrd.text = aDesc
        hargaOrd.text = aHarga.toString()
        imageOrd.setImageResource(aImg)

        fun display(number: Int) {
            val displayInteger = findViewById<View>(R.id.JmlOrd) as TextView

            displayInteger.text = "" + number

            toHarga = hargaOrd.text.toString().toInt() * displayInteger.text.toString().toInt()
            TotHarOrd.text = toHarga.toString()
        }
        //tombol kurang
        descreaseOrd.setOnClickListener() {
            if (minteger == MIN_NUMBER) {
                minteger = 0
            } else {
                minteger = minteger - 1
                display(minteger)
            }
        }
        //tombol tambah
        increaseOrd.setOnClickListener() {
            minteger = minteger + 1
            display(minteger)
        }

        OrderLagi.setOnClickListener {
            onBackPressed()
        }

        Bayar.setOnClickListener {
            val intent = Intent(applicationContext, Pembayaran::class.java)

            intent.putExtra("pSepatu", aSepatu)
            intent.putExtra("pDesc", aDesc)
            intent.putExtra("pHarga", aHarga)
            intent.putExtra("pImg", aImg)
            intent.putExtra("total", minteger)
            startActivity(intent)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}