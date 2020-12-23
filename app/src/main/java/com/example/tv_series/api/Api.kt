package com.example.tv_series.api

import com.example.tv_series.model.Movies
import retrofit2.http.GET

interface SimpleApi {
    @GET("nikoloz14/movies-db/db")
    suspend fun getMovies(): Movies
}