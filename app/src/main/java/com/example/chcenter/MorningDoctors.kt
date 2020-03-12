package com.example.chcenter

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chcenter.adapters.AdapterMain
import com.example.chcenter.models.ModelMainData
import com.example.chcenter.models.ModelNestedData
import kotlinx.android.synthetic.main.activity_morning_doctors.*
import kotlinx.android.synthetic.main.activity_programs.*

class MorningDoctors : AppCompatActivity() {


    var arrayList = ArrayList<ModelMainData>()

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning_doctors)
        setSupportActionBar(toolbar19)

        getSupportActionBar()!!.setTitle("TODAY NOTES")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initData()
        recycler_main.adapter = AdapterMain(this,arrayList){ mainIndex,innerIndex->

            Toast.makeText(this,arrayList[mainIndex].mainHeading + " " + arrayList[mainIndex].dataList[innerIndex].title,
                Toast.LENGTH_LONG).show()

        }


    }

    //init list with data
    private fun initData() {
        var arrayListData = listOf("WARD M.O","ENERAL O.P", "GENERAL MEDICINE O.P", "PEDIATRICIAN DEPARTMENT", "ORTHOPEDIATRICIAN DEPARTMENT", "OPHTHALMOLOGIST DEPARTMENT")

        for (i in 0..4){ // data for main recycler

          //  val mainHeading = "Heading $i"
            val mainHeading = arrayListData[i]
            val innerArray = ArrayList<ModelNestedData>()
            if(i ==0){
                innerArray.add(ModelNestedData("Dr ARUN KK", "MBBS"))
                innerArray.add(ModelNestedData("Dr RAJEEV", "MD"))
            }
            if(i ==1){
                innerArray.add(ModelNestedData("Dr AANUPAMA", "MBBS"))
                innerArray.add(ModelNestedData("HARI", "PG"))
            }
            if(i ==2){
                innerArray.add(ModelNestedData("Dr. Sree Kumar", "MD DCH"))
                innerArray.add(ModelNestedData("Dr. Sasidharan", "MBBS"))
            }
            if(i ==3){
                innerArray.add(ModelNestedData("Dr. Ajitha PN", "MBBS"))
                innerArray.add(ModelNestedData("Dr. K Mohandas", "MD"))
            }
            if(i ==4){
                innerArray.add(ModelNestedData("Dr. Rajesh Purushothaman", "MBBS"))
                innerArray.add(ModelNestedData("Dr.Abdul Latheef", "MD"))
            }

//            for (j in 0..4) { // data for inner recycler
//                innerArray.add(ModelNestedData("Title $j", "Message $j"))
//
//
//            }

            arrayList.add(ModelMainData(mainHeading,innerArray))

        }

    }
}
