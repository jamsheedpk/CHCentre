package com.example.chcenter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chcenter.activities.DoctorsActivity
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.DoctorModelRequest
import com.example.chcenter.api.model.Doctors
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_doctor_details.*

class DoctorDetails : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)


        btnDoctorDetails.setOnClickListener {

            val strName: String = etName.text.toString()
            val strSpecialisation: String = etSpecialisation.text.toString()
            val strPlace: String = etPlace.text.toString()
            val strContactNumber: String = etContact.text.toString()
            val intId = "";
            val strEmail="";
            val createdAt ="";
            val strAddress ="";
            val strGender ="";
            val objRequestDoctorDetails =
                Doctors(intId,strName, strSpecialisation, strPlace, strContactNumber,createdAt,strEmail,strAddress,strGender)

            apiService.run {
                saveDoctorDetails(objRequestDoctorDetails)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d("Successful ", "response from api ${result}")

                            if(result.success == true){
                                Toast.makeText(
                                    this@DoctorDetails,
                                     "Successful DoctorDetails Saved !",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else{
                                Toast.makeText(
                                    this@DoctorDetails,
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


        btnUserList.setOnClickListener {
            apiService.run {
                getAllUserList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d(
                                "Successful Dr Register",
                                "response from api ${result.data.get(0)}"
                            )

                        },
                        { error ->
                            Log.e(" Error", "response from api ${error.localizedMessage}")
                        }
                    )
            }
        }

    }
}