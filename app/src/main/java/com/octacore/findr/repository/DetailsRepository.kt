package com.octacore.findr.repository

import com.octacore.findr.handlers.ResponseHandler
import com.octacore.findr.network.DetailsServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object DetailsRepository {
    private val service = DetailsServices.createService()

    fun getCardDetails(bin: String, handler: ResponseHandler){
        GlobalScope.launch(Dispatchers.Main) {
            val request = service.getCardDetailsAsync(bin)
            try {
                val response = request.await()
                if (response.isSuccessful){
                    val body = response.body()
                    handler.success(body!!)
                } else{
                    handler.failed("Fetching card details not successful: ", response.code().toString())
                }
            } catch (err: Exception){
                handler.failed("Error in fetching card details: ", err.message!!)
            }
        }
    }
}