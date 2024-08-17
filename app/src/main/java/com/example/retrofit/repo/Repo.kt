package com.example.retrofit.repo
import com.example.retrofit.network.IRemoteDataSource
import com.example.retrofit.network.RemoteDataSource

class Repo(private val remoteDataSource: IRemoteDataSource = RemoteDataSource()) : IRepo {

    override suspend fun getProductsOnline() = remoteDataSource.getProducts()
    override suspend fun getProductOnline(id: Int) = remoteDataSource.getProduct(id)

}