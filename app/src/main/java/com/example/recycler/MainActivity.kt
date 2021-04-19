package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<sepatumodel>()
        arrayItem.add(sepatumodel("Adidas","cocok untuk anda",R.drawable.adidas,25000))
        arrayItem.add(sepatumodel("Brodo","cocok untuk anda",R.drawable.brodo,30000))
        arrayItem.add(sepatumodel("Converse","cocok untuk anda ",R.drawable.convers,20000))
        arrayItem.add(sepatumodel("Diadora","cocok untuk anda",R.drawable.diadora,45000))
        arrayItem.add(sepatumodel("League","cocok untuk anda",R.drawable.league,70000))
        arrayItem.add(sepatumodel("New Balance","cocok untuk anda",R.drawable.newbalance,34000))
        arrayItem.add(sepatumodel("Nike","cocok untuk anda",R.drawable.nike,33000))
        arrayItem.add(sepatumodel("Puma","cocok untuk anda",R.drawable.puma,25000))
        arrayItem.add(sepatumodel("Rebook","cocok untuk anda",R.drawable.recook,34000))
        arrayItem.add(sepatumodel("Vans","cocok untuk anda",R.drawable.vans,50000))
        arrayItem.add(sepatumodel("Wakai","cocok untuk anda",R.drawable.wakai,90000))

        var myAdapter = sepatuadapter(arrayItem, this)

        RV_Sepatu.layoutManager = LinearLayoutManager(this)
        RV_Sepatu.adapter = myAdapter



    }

}