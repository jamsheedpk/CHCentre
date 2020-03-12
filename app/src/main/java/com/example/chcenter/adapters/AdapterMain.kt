package com.example.chcenter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chcenter.R
import com.example.chcenter.models.ModelMainData


class AdapterMain(val context : Context, val data : ArrayList<ModelMainData>, val onItemClick : (Int, Int) -> Unit) : RecyclerView.Adapter<AdapterMain.MainItemVH>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemVH {

        return MainItemVH(LayoutInflater.from(parent.context).inflate(R.layout.recycler_main_item,parent,false))

    }

    override fun getItemCount(): Int {
        return data.size

    }

    override fun onBindViewHolder(holder: MainItemVH, position: Int) {

        holder.mTxtMainHeading.text = data[position].mainHeading
        holder.mReyclerNested.adapter = AdapterNested(context,data[position].dataList){innerPosition ->
            onItemClick(position,innerPosition)
        }

    }

    class MainItemVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val mReyclerNested by lazy { itemView.findViewById<RecyclerView>(R.id.reyclerNested) }
         val mTxtMainHeading by lazy { itemView.findViewById<TextView>(R.id.txtMainHeading) }
    }
}