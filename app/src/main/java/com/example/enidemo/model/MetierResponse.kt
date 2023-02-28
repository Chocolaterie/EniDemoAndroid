package com.example.enidemo.model

class MetierResponse<T> (var codeResponse : String, var messageResponse :String, var objectResult: T) {

    fun getMessage() : String {
        return String.format("%s - %s", codeResponse, messageResponse)
    }

    fun getObject() : T {
        return objectResult
    }
}