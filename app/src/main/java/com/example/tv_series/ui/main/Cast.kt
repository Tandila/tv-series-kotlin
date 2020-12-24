package com.example.tv_series.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tv_series.MainActivity2.Companion.detailedMovie
import com.example.tv_series.R
import com.example.tv_series.mainPage.MainPageAdapter
import com.example.tv_series.model.MoviesData


class Cast : Fragment() {

    private var castNameList = mutableListOf<String>()
    private var castPlayList = mutableListOf<String>()
    private var imageList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_cast, container, false)
        val rv_cast: RecyclerView = root.findViewById(R.id.rv_cast)
        rv_cast.layoutManager = LinearLayoutManager(root.context)
        rv_cast.adapter = CastAdapter(castNameList, castPlayList, imageList)
        postToList()
        return root
    }

    private fun addToList(castName: String, castPlay: String, Image: String) {
        castNameList.add(castName)
        castPlayList.add(castPlay)
        imageList.add(Image)
    }
    private fun postToList() {
        for (i in detailedMovie.cast) {
            addToList(i.fullName, i.role, i.imageUrl)
        }
    }

}