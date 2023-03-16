package com.example.mvcexample

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvcexample.controller.ILoginController
import com.example.mvcexample.controller.LoginController
import com.example.mvcexample.view.ILoginView

class MainActivity : AppCompatActivity(), ILoginView {

    var email: EditText? = null
    var password: EditText? = null
    var loginBtn: Button? = null
    var loginController: ILoginController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email = findViewById(R.id.edtUserName)
        password = findViewById(R.id.edtPassword)
        loginBtn = findViewById(R.id.mButtonLogin)
        loginController = LoginController(this)

        loginBtn?.setOnClickListener {
            (loginController as LoginController).onLogin(
                email?.text.toString(),
                password?.text.toString().trim()
            )
        }
    }

    override fun onLoginSuccess(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onLoginError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}