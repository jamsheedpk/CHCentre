package com.example.chcenter

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_donation.*

class DonationActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)
        setSupportActionBar(toolbar)

        getSupportActionBar()!!.setTitle("Donations")
        getSupportActionBar()!!.setDefaultDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imagefood.setOnClickListener {
            val intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }


        imagepayment.setOnClickListener {
            val intent = Intent(this, OnCashActivity::class.java)
            startActivity(intent)
        }
    }
}
