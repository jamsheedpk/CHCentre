package com.example.chcenter.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chcenter.R
import com.example.chcenter.activities.MainActivity
import com.example.chcenter.models.BloodGroupModels
import kotlinx.android.synthetic.main.list_view_bloodgroups.view.*


class BloodGroupAdapter(val context: Context, private val bloodGroups: List<BloodGroupModels>) :
    RecyclerView.Adapter<BloodGroupAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(context).inflate(R.layout.list_view_bloodgroups, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {


        return bloodGroups.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val bloodGroups = bloodGroups[position]
        holder.setData(bloodGroups, position)


    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentBloodGroup: BloodGroupModels? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentBloodGroup?.let {
                    Toast.makeText(
                        context,
                        currentBloodGroup!!.Name + "Clicked !",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        fun setData(bloodGroups: BloodGroupModels?, pos: Int) {
            bloodGroups?.let {

                itemView.txvName.text = bloodGroups?.Name
                itemView.txvBloodGroup.text = bloodGroups?.Bloodgroup
                itemView.txvContact.text = bloodGroups?.Phoneno
            }

            this.currentBloodGroup = bloodGroups


        }
    }
}












