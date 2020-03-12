package com.example.chcenter.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.R
import com.example.chcenter.adapters.BloodGroupAdapter
import com.example.chcenter.api.ApiService
import com.example.chcenter.models.Bloodgrouplist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_ambulances.*
import kotlinx.android.synthetic.main.activity_blood_groups.*
import kotlinx.android.synthetic.main.activity_blood_groups.recyclerView

class BloodGroupsActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }
    companion object {
        val TAG: String = BloodGroupsActivity::class.java.simpleName
    }

    private val apiService by lazy {
        ApiService.create()
    }


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_groups)
        setSupportActionBar(toolbar2)

        getSupportActionBar()!!.setTitle("BloodGroups")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val adapter = ArrayAdapter.createFromResource(this, R.array.bloodgroups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this


        setupRecyclerView()


    }

    fun getBloodgroupsList() {
        apiService.run {
            bloodgrouplistview()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("Successful Dr Register", "response from api ${result}")

                    },
                    { error ->

                        Log.e(" Error", "response from api ${error.localizedMessage}")
                    }
                )
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = BloodGroupAdapter(
            this,
            Bloodgrouplist.Bloodgroups
        )

        recyclerView.adapter = adapter

    }
}

