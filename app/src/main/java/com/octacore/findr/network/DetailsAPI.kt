package com.octacore.findr.network

import com.octacore.findr.model.CardModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailsAPI {
    @GET("/{bin}")
    fun getCardDetails(@Path("bin") bin: String): Deferred<Response<CardModel>>
}