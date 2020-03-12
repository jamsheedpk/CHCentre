package com.example.chcenter.details

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chcenter.R
import com.example.chcenter.api.ApiService
import com.example.chcenter.api.model.Freezers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_freezer_details.*

class FreezerDetails : AppCompatActivity() {


    private val apiService by lazy {
        ApiService.create()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_freezer_details)




        btndone.setOnClickListener {

            val strName: String = etEnterName.text.toString()
            val strContactNumber: String = editText.text.toString()
            val intId = "";
            val objRequestFreezersDetails =
                Freezers(intId,strName, strContactNumber)

            apiService.run {
                SaveFreezerDetails(objRequestFreezersDetails)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { result ->
                            Log.d("Successful ", "response from api ${result}")

                            if(result.success == true){
                                Toast.makeText(
                                    this@FreezerDetails,
                                    "Successful Freezers Data !",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            else{
                                Toast.makeText(
                                    this@FreezerDetails,
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
