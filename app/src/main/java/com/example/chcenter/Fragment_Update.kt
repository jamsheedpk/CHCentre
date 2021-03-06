package com.example.chcenter

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_update.view.*

class Fragment_Update : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.fragment_update, container,false)
        view.layout_doctor.setOnClickListener {view->
            val intent=Intent(activity,MorningDoctors::class.java)
            startActivity(intent)
        }
        view.layout_programs.setOnClickListener { view ->
            val intent = Intent(activity, Programs::class.java)
            startActivity(intent)
        }
        view.layout_requirements.setOnClickListener { view ->
            val intent = Intent(activity, Requirments::class.java)
            startActivity(intent)
        }
        return view


    }



}
