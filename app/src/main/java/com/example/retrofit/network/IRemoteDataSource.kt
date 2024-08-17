package com.example.retrofit.network
import com.example.retrofit.models.Product

interface IRemoteDataSource {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product
}