package com.example.retrofit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.models.Product
import com.example.retrofit.repo.IRepo
import com.example.retrofit.repo.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: IRepo = Repo()) : ViewModel() {

    private val _products: MutableLiveData<List<Product>> = MutableLiveData(emptyList())
    val products: LiveData<List<Product>>
        get() = _products

    init { getAllProducts() }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            _products.postValue(repo.getProductsOnline())
        }
    }
}