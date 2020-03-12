package com.example.chcenter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chcenter.R
import com.example.chcenter.activities.MainActivity
import com.example.chcenter.models.ProgramModel
import com.example.chcenter.models.RequirmentModels
import kotlinx.android.synthetic.main.activity_add_blood.view.*
import kotlinx.android.synthetic.main.list_view_requirments.view.*
import kotlinx.android.synthetic.main.listview_programs.view.*

class RequirmentAdapter(val context: Context, private val Requirments: List<RequirmentModels>) :
    RecyclerView.Adapter<RequirmentAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_view_requirments, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {


        return Requirments.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val docter = Requirments[position]
        holder.setData(docter, position)


    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentReq: RequirmentModels? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {


                currentReq?.let {
                    Toast.makeText(context, currentReq!!.name + "Clicked !", Toast.LENGTH_SHORT)
                        .show()


                }

            }
        }

        fun setData(requirement: RequirmentModels?, pos: Int) {
            requirement?.let {

                itemView.txvNameR.text = requirement?.name
                itemView.txvContactR.text = requirement?.contact
                itemView.txvVenueR.text = requirement?.venue
               // itemView.txvDate.text = program?.date
            }

            this.currentReq = requirement


        }
    }
}
