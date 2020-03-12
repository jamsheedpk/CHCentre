package com.example.chcenter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.VolunteerModelRequest
import com.example.chcenter.api.model.Volunteers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_volunteer.*

class VolunteerDetails : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)

        btnVolunteer.setOnClickListener {
            val intId ="";
            val strVolunteerName: String = etVolunteerName.text.toString()
            val strVolunteerAge: String = etVolunteerAge.text.toString()
            val strVolunteerPlace: String = etVolunteerPlace.text.toString()
            val strVolunteerContact: String = etVolunteerContact.text.toString()
            val objRequestVolunteerDetails = Volunteers(
                intId,
                strVolunteerName,
                strVolunteerContact
            )

            apiService.run {
                SaveVolunteerDetails(objRequestVolunteerDetails)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d("Successful ", "response from api ${result}")

                            if(result.success == true){
                                Toast.makeText(
                                    this@VolunteerDetails,
                                    "Successful DoctorDetails Saved !",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else{
                                Toast.makeText(
                                    this@VolunteerDetails,
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
            }

        }
    }
}