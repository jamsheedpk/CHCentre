package com.example.chcenter.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chcenter.R
import com.example.chcenter.adapters.FreezerAdapter
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Freezers
import com.example.chcenter.models.Freezerlist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_freezers.*

class FreezersActivity : AppCompatActivity() {

    companion object {
        val TAG: String = FreezersActivity::class.java.simpleName
    }

    private val apiService by lazy {
        ApiService.create()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freezers)
        setSupportActionBar(toolbar11)

        getSupportActionBar()!!.setTitle("Freezers")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        getFreezerList()


    }

    fun getFreezerList(){
        apiService.run{
            getFreezerDetailsData()
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

    private fun setupRecyclerView(data:List<Freezers>) {
        val layoutManager = LinearLayoutManager(this)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = FreezerAdapter(
            this, data
        )

        recyclerView.adapter = adapter

    }
}

