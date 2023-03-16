package com.example.mvcexample.view

interface ILoginView {

    fun onLoginSuccess(message: String?)
    fun onLoginError(message: String?)

}