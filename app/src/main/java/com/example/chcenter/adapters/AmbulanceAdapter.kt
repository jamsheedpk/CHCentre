package com.example.chcenter.adapters


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chcenter.R
import com.example.chcenter.activities.MainActivity
import com.example.chcenter.api.model.Ambulances

import kotlinx.android.synthetic.main.list_view_ambulance.view.*


class AmbulanceAdapter(val context: Context, private val ambulances: List<Ambulances>) :
    RecyclerView.Adapter<AmbulanceAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_view_ambulance, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {


        return ambulances.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val ambulance = ambulances[position]
        holder.setData(ambulance, position)


    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currenctAmbulance: Ambulances? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currenctAmbulance?.let {
                    Toast.makeText(
                        context,
                        currenctAmbulance!!.strName + "Clicked !",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }



            itemView.imgShare.setOnClickListener {

                currenctAmbulance?.let {
                    val message: String = currenctAmbulance!!.strName

                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "text/plain"

                    context.startActivity(Intent.createChooser(intent, "Please select app:"))

                }

            }
        }

        fun setData(ambulance: Ambulances?, pos: Int) {
            ambulance?.let {

                itemView.txvContact.text = ambulance?.strContactNumber
                itemView.txvName.text = ambulance?.strName
            }

            this.currenctAmbulance = ambulance


        }
    }
}












