package com.example.tv_series

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tv_series.mainPage.MainPageAdapter
import com.example.tv_series.model.MoviesData
import com.example.tv_series.repository.Repository

class MainActivity : AppCompatActivity() {

    companion object {
        var moviesGlobal = mutableListOf<MoviesData>()
    }

    private lateinit var viewModel: MainViewModel
    private var imageList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv_recyclerView: RecyclerView = findViewById(R.id.rv_recyclerView)


        rv_recyclerView.layoutManager = LinearLayoutManager(this)
        rv_recyclerView.adapter = MainPageAdapter(imageList)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getMovies()
        viewModel.myResponse.observe(this, {response ->
            postToList(response.movies)
            moviesGlobal = response.movies.toMutableList()
        })
    }

    private fun addToList(image: String) {
        imageList.add(image)
    }
    private fun postToList(movies: Array<MoviesData>) {
        for (i in movies) {
            addToList(i.imageUrl)
        }
    }

}