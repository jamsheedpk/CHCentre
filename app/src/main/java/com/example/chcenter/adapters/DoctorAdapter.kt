package com.example.chcenter.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chcenter.R
import com.example.chcenter.activities.MainActivity
import com.example.chcenter.api.model.Doctors
import kotlinx.android.synthetic.main.list_view_docter.view.*


class DoctorAdapter(val context: Context, private val docters: List<Doctors>) :
    RecyclerView.Adapter<DoctorAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.list_view_docter, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {


        return docters.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val docter = docters[position]
        holder.setData(docter, position)


    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currenctDoctor: Doctors? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {


                currenctDoctor?.let {
                    Toast.makeText(context, currenctDoctor!!.strName + "Clicked !", Toast.LENGTH_SHORT)
                        .show()


                }

            }
        }

        fun setData(docter: Doctors?, pos: Int) {
            docter?.let {

                itemView.txvContact.text = docter?.strContactNumber
                itemView.txvName.text = docter?.strName
                itemView.txvSepecialization.text = docter?.strContactNumber
                itemView.txvPlace.text = docter?.strPlace
            }

            this.currenctDoctor = docter


        }
    }
}












