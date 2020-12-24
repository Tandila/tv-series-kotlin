package com.example.tv_series

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.TextureView
import android.widget.TextView
import com.example.tv_series.MainActivity.Companion.moviesGlobal
import com.example.tv_series.model.MoviesData
import com.example.tv_series.ui.main.SectionsPagerAdapter

class MainActivity2 : AppCompatActivity() {

    companion object {
        lateinit var detailedMovie: MoviesData
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val result = intent.getStringExtra("result")
        if (result != null) {
            detailedMovie = moviesGlobal[result.toInt()]
        }

    }
}