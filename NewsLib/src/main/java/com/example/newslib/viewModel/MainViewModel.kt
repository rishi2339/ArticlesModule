package com.example.newslib.viewModel

import MainRepository
import MyResponse
import com.example.newslib.data.model.Response
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newslib.data.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository:MainRepository): ViewModel(){
    val itemsLiveData: LiveData<MyResponse<Article>> = repository.articles
    val pageNumber = ObservableField<Int>()
    val pageLoading = ObservableField<Boolean>()

    init {
        pageNumber.set(1)
        fetchItems()
    }

    private fun fetchItems(){
        pageLoading.set(true)
        viewModelScope.launch(Dispatchers.IO) {
            repository.getItems(page = 1)
            pageLoading.set(false)
        }
    }
}