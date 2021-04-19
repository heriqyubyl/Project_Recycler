package com.example.recycler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class sepatuadapter (val arrayList: ArrayList<sepatumodel>,
                     val context : Context):
RecyclerView.Adapter<sepatuadapter.ViewHolder>(){

    class ViewHolder(itemview : View) :RecyclerView.ViewHolder(itemview){
         fun bindItems (model : sepatumodel){
             itemView.namasepatu.text = model.nmsepatu
             itemView.descsepatu.text = model.dessepatu
             itemView.hargasepatu.text = model.hargasepatu.toString()
             itemView.imgsepatu.setImageResource(model.imagesepatu)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener(){
            val model = arrayList.get(position)

            var gsepatu : String = model.nmsepatu
            var gDesc   : String = model.dessepatu
            var gHarga  : Int = model.hargasepatu.toString().toInt()
            var gImg    : Int    = model.imagesepatu

            val intent = Intent(context, OrderActivity::class.java)
            intent.putExtra("pSepatu", gsepatu)
            intent.putExtra("pDesc", gDesc)
            intent.putExtra("pHarga", gHarga)
            intent.putExtra("pImg", gImg)

            context.startActivity(intent)
        }
    }
}