package com.example.androidtechtest.presentation.state

data class DataOrException<T, Boolean,E:Exception>(
    var data:T?= null,
    var loading:Boolean? = null,
    var error:Exception? = null
) {
}