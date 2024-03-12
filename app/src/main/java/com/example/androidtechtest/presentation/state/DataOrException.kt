package com.example.androidtechtest.presentation.state

class DataOrException<T, Boolean,E:Exception>(
    var data:T?= null,
    var loading:Boolean? = null,
    var error:Exception? = null
) {
}