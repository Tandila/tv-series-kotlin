package com.example.tv_series.repository

import com.example.tv_series.api.RetrofitInstance
import com.example.tv_series.model.Movies

class Repository {
    suspend fun getMovies(): Movies{
        return RetrofitInstance.api.getMovies()
    }
}