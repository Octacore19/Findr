package com.octacore.findr.viewmodel

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.octacore.findr.handlers.ResponseHandler
import com.octacore.findr.model.CardModel
import com.octacore.findr.repository.DetailsRepository.getCardDetails

class DetailsActivityViewModel(app: Application): AndroidViewModel(app) {

    val brand = MutableLiveData<String>()
    val type = MutableLiveData<String>()
    val bank = MutableLiveData<String>()
    val country = MutableLiveData<String>()

    init {
        brand.value = ""
        type.value = ""
        bank.value = ""
        country.value = ""
    }

    fun getCardDetails(intent: Intent){
        val bin = intent.getStringExtra("data")
        getCardDetails(bin!!, object : ResponseHandler{
            override fun success(data: Any) {
                val card = data as CardModel
                brand.value = card.brand
                type.value = card.type
                bank.value = card.bank.name
                country.value = card.country.name
            }

            override fun failed(title: String, reason: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}