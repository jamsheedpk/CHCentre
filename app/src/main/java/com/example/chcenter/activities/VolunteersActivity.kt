package com.example.chcenter.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.R
import com.example.chcenter.adapters.VolunteerAdapter
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Volunteers
import com.example.chcenter.models.Volunteerlist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_volunteers.*

class VolunteersActivity : AppCompatActivity() {

    companion object {
        val TAG: String = VolunteersActivity::class.java.simpleName
    }

    private val apiService by lazy {
        ApiService.create()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteers)

        setSupportActionBar(toolbar5)

        getSupportActionBar()!!.setTitle("Volunteers")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        getVolunteerList()


    }

    fun getVolunteerList() {
        apiService.run{
            getVolunteerDetailsData()
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

    private fun setupRecyclerView(volunteers:List<Volunteers>) {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager


        val adapter = VolunteerAdapter(
            this,volunteers
        )

        recyclerView.adapter = adapter

    }
}

