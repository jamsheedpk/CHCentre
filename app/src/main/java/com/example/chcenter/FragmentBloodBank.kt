package com.example.chcenter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.chcenter.activities.BloodGroupsActivity
import kotlinx.android.synthetic.main.fragment_bloodbank.*

class FragmentBloodBank : Fragment(), AdapterView.OnItemSelectedListener {





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_bloodbank, null)

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        search.setOnClickListener {
            val intent=Intent(activity,BloodGroupsActivity::class.java)
            startActivity(intent)
        }
        add.setOnClickListener {
            val intent= Intent(activity,AddBlood::class.java)
            startActivity(intent)
        }
    }

    private fun setContentView(activitySearchblood: Int) {

    }

    override fun onItemSelected(
        parent: AdapterView<*>, view: View, position

        : Int, l: Long
    ) {
        val text = parent.getItemAtPosition(position).toString()



    }
    override fun onNothingSelected(adapterView: AdapterView<*>) {
    }

}