package com.octacore.findr.handlers

interface ResponseHandler {
    fun success(data: Any)
    fun failed(title: String, reason: String)
}