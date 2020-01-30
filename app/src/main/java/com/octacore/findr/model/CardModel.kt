package com.octacore.findr.model

data class CardModel(
    val bank: BankModel,
    val brand: String,
    val country: CountryModel,
    val scheme: String,
    val type: String
)