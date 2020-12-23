package com.example.tv_series.model

import java.util.*

data class Movies(
    val movies: Array<MoviesData>
)

data class MoviesData(
    val id: Int,
    val title: String,
    val date: String,
    val language: String,
    val seasons: Int,
    val imageUrl: String,
    val cast: Array<CastData>
)
data class CastData(
    val id: Int,
    val fullName: String,
    val role: String,
    val imageUrl: String
)