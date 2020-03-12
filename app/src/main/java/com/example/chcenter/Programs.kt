package com.example.chcenter

import android.annotation.SuppressLint
import android.app.TaskStackBuilder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.adapters.BloodGroupAdapter
import com.example.chcenter.adapters.DoctorAdapter
import com.example.chcenter.adapters.FreezerAdapter
import com.example.chcenter.adapters.ProgramAdapter
import com.example.chcenter.models.Bloodgrouplist
import com.example.chcenter.models.Programlist
import kotlinx.android.synthetic.main.activity_add_blood.*
import kotlinx.android.synthetic.main.activity_blood_groups.*
import kotlinx.android.synthetic.main.activity_donation.*
import kotlinx.android.synthetic.main.activity_programs.*

class Programs : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programs)
        setSupportActionBar(toolbar14)

        getSupportActionBar()!!.setTitle("PROGRAMS")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupRecyclerView()

    }
    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewP.layoutManager = layoutManager

        val adapter = ProgramAdapter(
            this, Programlist.programs
        )

        recyclerViewP.adapter = adapter

    }
}

