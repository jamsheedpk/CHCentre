package com.example.chcenter

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.adapters.ProgramAdapter
import com.example.chcenter.adapters.RequirmentAdapter
import com.example.chcenter.models.Programlist
import com.example.chcenter.models.RequirmentModels
import com.example.chcenter.models.Requirments
import kotlinx.android.synthetic.main.activity_programs.*
import kotlinx.android.synthetic.main.activity_requirments.*

class Requirments : AppCompatActivity() {
    
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_requirments)
        setSupportActionBar(toolbar50)


        getSupportActionBar()!!.setTitle("Reqirments")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewReq.layoutManager = layoutManager

        val adapter = RequirmentAdapter(
            this, Requirments.Requirments
        )

        recyclerViewReq.adapter = adapter

    }
}
