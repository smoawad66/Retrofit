package com.example.retrofit.repo

import com.example.retrofit.models.Product

interface IRepo {
    suspend fun getProductsOnline(): List<Product>
    suspend fun getProductOnline(id: Int): Product
}