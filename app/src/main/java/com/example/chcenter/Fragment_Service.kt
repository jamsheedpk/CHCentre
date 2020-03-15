package com.example.chcenter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chcenter.activities.AmbulancesActivity
import com.example.chcenter.activities.DoctorsActivity
import com.example.chcenter.activities.FreezersActivity
import com.example.chcenter.activities.VolunteersActivity
import kotlinx.android.synthetic.main.fragment_service.view.*


class Fragment_Service : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_service, container, false)
        view.layout_ambulance.setOnClickListener { view ->
            val intent = Intent(activity, AmbulancesActivity::class.java)
            startActivity(intent)
        }

        view.layout_doctor.setOnClickListener { view ->
            val intent = Intent(activity, DoctorsActivity::class.java)
            startActivity(intent)
        }

        view.layout_volunteer.setOnClickListener { view ->
            val intent = Intent(activity, VolunteersActivity::class.java)
            startActivity(intent)
        }

        view.layout_freezer.setOnClickListener { view ->
            val intent = Intent(activity, FreezersActivity::class.java)
            startActivity(intent)
        }

        return view
    }


}

