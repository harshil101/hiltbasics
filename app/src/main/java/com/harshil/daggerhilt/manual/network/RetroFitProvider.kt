package com.harshil.daggerhilt.manual.network

import retrofit2.Retrofit

object RetroFitProvider {
    fun createRetrofitInstance() = Retrofit.Builder()
        .baseUrl("https://example.com")
        .build()
        .create(ServiceDI::class.java)
}