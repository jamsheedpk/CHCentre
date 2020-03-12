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
import kotlinx.android.synthetic.main.activity_add_blood.view.*
import kotlinx.android.synthetic.main.listview_programs.view.*

class ProgramAdapter(val context: Context, private val programs: List<ProgramModel>) :
    RecyclerView.Adapter<ProgramAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.listview_programs, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {


        return programs.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val docter = programs[position]
        holder.setData(docter, position)


    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currenctProgram: ProgramModel? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {


                currenctProgram?.let {
                    Toast.makeText(context, currenctProgram!!.name + "Clicked !", Toast.LENGTH_SHORT)
                        .show()


                }

            }
        }

        fun setData(program: ProgramModel?, pos: Int) {
            program?.let {

                itemView.txvName.text = program?.name
                itemView.txvContact.text = program?.contact
                itemView.txvVenue.text = program?.venue
                itemView.txvDate.text = program?.date
            }

            this.currenctProgram = program


        }
    }
}
