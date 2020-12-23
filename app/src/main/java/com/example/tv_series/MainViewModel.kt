package com.example.tv_series

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tv_series.model.Movies
import com.example.tv_series.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Movies> = MutableLiveData()

    fun getMovies() {
        viewModelScope.launch {
            val response = repository.getMovies()
            myResponse.value = response
        }
    }
}