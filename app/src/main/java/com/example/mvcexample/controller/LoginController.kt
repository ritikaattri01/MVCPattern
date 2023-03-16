package com.example.mvcexample.controller

import com.example.mvcexample.model.User
import com.example.mvcexample.view.ILoginView

class LoginController(private val loginView: ILoginView) : ILoginController {
    override fun onLogin(email: String?, password: String?) {
        val user = User(email, password)

        when (user.isValid()) {
            0 -> {
                loginView.onLoginError("Please enter Email")
            }
            1 -> {
                loginView.onLoginError("Please enter A valid Email")
            }
            2 -> {
                loginView.onLoginError("Please enter Password")
            }
            3 -> {
                loginView.onLoginError("Please enter Password greater the 6 char")
            }
            else -> {
                loginView.onLoginSuccess("login Successful")
            }
        }
    }
}