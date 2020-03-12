package com.example.chcenter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Bloodgroups
import com.example.chcenter.api.model.Freezers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_add_blood.*
import kotlinx.android.synthetic.main.activity_freezer_details.*

class AddBlood : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_blood)
        setSupportActionBar(toolbar12)
        getSupportActionBar()!!.setTitle("AddBlood")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnSave.setOnClickListener {

            val strName: String = txtName.text.toString()
            val strAge: String = txtAge.text.toString()
            val strLastDonationDate: String = txtDate.text.toString()
            val strBloodGroup: String = txtBloodGroup.text.toString()
            val strContactNumber: String = txtContact.text.toString()
            val intId = "";
            val createdAt="";
            val objRequestFreezersDetails =
                Bloodgroups(intId,strName, strContactNumber,strAge,strLastDonationDate,strBloodGroup,createdAt)
        apiService.run {
            SaveBloodGroupDetails(objRequestFreezersDetails)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        Log.d("Successful ", "response from api ${result}")

                        if(result.success == true){
                            Toast.makeText(
                                this@AddBlood,
                                "Successful Freezers Data !",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else{
                            Toast.makeText(
                                this@AddBlood,
                                "Warning: ${result.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.d("Error", "response from api ${result.message}")
                        }


                    },
                    { error ->
                        Log.e(" Error", "response from api ${error.localizedMessage}")
                    }
                )
        } }

    }
}
