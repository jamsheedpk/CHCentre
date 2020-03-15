package com.example.chcenter

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.RequiresApi
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.chcenter.details.FreezerDetails

import com.example.chcenter.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_donation.*
import kotlinx.android.synthetic.main.fragment_service.*


class Main2Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.fragment_container)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val toolbar: Toolbar = findViewById(R.id.toolbar);
        toolbar.title = "CH Centre"
        setSupportActionBar(toolbar)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.example_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_donation -> {

                // val  intent= Intent(this,Office::class.java)
                val intent = Intent(this, DonationActivity::class.java)
                startActivity(intent)
            }
            R.id.item_office -> {

                // val  intent= Intent(this,Office::class.java)
                val intent = Intent(this, Office_Activity::class.java)
                startActivity(intent)
            }
            R.id.item_history -> {
                val intent = Intent(this, History_Activity::class.java)
                startActivity(intent)


            }
            R.id.item_profile -> {
                val intent = Intent(this, Profile_Activity::class.java)
                startActivity(intent)

            }

            R.id.item_ambulance ->{
                val intent = Intent(this, Ambulance_Registration::class.java)
                startActivity(intent)

            }
            R.id.item_doctor ->{
                val intent = Intent(this, DoctorDetails::class.java)
                startActivity(intent)

            }
            R.id.item_volunteer ->{
                val intent = Intent(this, VolunteerDetails::class.java)
                startActivity(intent)

            }
            R.id.item_Freezer ->{
                val intent = Intent(this, FreezerDetails::class.java)
                startActivity(intent)

            }

        }
        return super.onOptionsItemSelected(item)
    }
}



