package com.example.retrofit.network

import com.example.retrofit.models.Product
import com.example.retrofit.models.ProductResponse

class RemoteDataSource(private val apiService: ApiService = RetrofitConnection.getService()):
    IRemoteDataSource {

    override suspend fun getProducts() = apiService.getProducts().products

    override suspend fun getProduct(id: Int) = apiService.getProduct(id)
}