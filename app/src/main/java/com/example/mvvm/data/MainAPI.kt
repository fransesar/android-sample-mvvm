package com.example.mvvm.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MainAPI {
    @GET("DevTides/DogsApi/master/dogs.json")
    fun getData(): Single<List<Dogs>>
}