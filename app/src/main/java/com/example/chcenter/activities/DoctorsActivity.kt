package com.example.chcenter.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.R
import com.example.chcenter.adapters.DoctorAdapter
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Doctors
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_doctors.*

class DoctorsActivity : AppCompatActivity() {

    companion object {
        val TAG: String = DoctorsActivity::class.java.simpleName


    }

    private val apiService by lazy {
        ApiService.create()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors)
        setSupportActionBar(toolbar4)

        getSupportActionBar()!!.setTitle("Doctor Details")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getDoctorList()



    }


    fun getDoctorList(){
        apiService.run{
            getDocoterlistview()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("Successful Dr Register", "response from api ${result.data}")

                        if(result.success == true){
                            setupRecyclerView(result.data)}
                        else{
                            Log.d("Error", "response from api ${result.message}")
                        }


                    },
                    { error ->
                        Log.e(" Error", "response from api ${error.localizedMessage}")
                    }
                )
        }


    }


    private fun setupRecyclerView(data:List<Doctors>) {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = DoctorAdapter(
            this, data
        )

        recyclerView.adapter = adapter

    }
}

