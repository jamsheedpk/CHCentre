package com.example.chcenter.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.R
import com.example.chcenter.adapters.AmbulanceAdapter
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Ambulances
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_ambulances.*

class AmbulancesActivity : AppCompatActivity() {

    companion object {
        val TAG: String = AmbulancesActivity::class.java.simpleName
    }
    private val apiService by lazy {
        ApiService.create()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambulances)

        setSupportActionBar(toolbar3)

        getSupportActionBar()!!.setTitle("Ambulance")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getAmbulanceList()



    }

    fun getAmbulanceList(){
        apiService.run{
            getAmbulanceDetailsData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("Successful Ambulance", "response from api ${result}")

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
    private fun setupRecyclerView(data:List<Ambulances>) {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager


        val adapter = AmbulanceAdapter(
            this, data
        )

        recyclerView.adapter = adapter

    }
}

