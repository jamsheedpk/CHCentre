package com.example.chcenter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Ambulances
import com.example.chcenter.api.model.Request
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_ambulance__registration.*

class Ambulance_Registration : AppCompatActivity() {

    private val apiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambulance__registration)


        btnSave.setOnClickListener {

            val strName: String = editName.text.toString()
           // val strJob: String = etJob.text.toString()
            //val strPlace: String = edit_location.text.toString()
            val intId ="";
            val strContactNumber: String = edit_contact.text.toString()
            val objRequestUserData = Ambulances(intId,strName, strContactNumber)

            apiService.run {
                saveAmbulanceDetails(objRequestUserData)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d("Successful ", "response from api ${result}")

                            if(result.success == true){
                                Toast.makeText(
                                    this@Ambulance_Registration,
                                    "Successful DoctorDetails Saved !",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else{
                                Toast.makeText(
                                    this@Ambulance_Registration,
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
