package com.example.griffinpiece.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import com.example.griffinpiece.ui.register.CreateAccount
import com.example.griffinpiece.MainActivity
import com.example.griffinpiece.R

class LoginActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar
    private lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        actionBar = supportActionBar!!
        actionBar.title = "Connecter-vous à votre compte"
        actionBar.setBackgroundDrawable(ColorDrawable(Color.parseColor("#040404")))

        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
        val intentConnected = Intent(application, MainActivity::class.java)


        this.loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)


        var sentEmail = this.intent.getStringExtra("email")
        var sentUsername = this.intent.getStringExtra("username")

        var loginEmail: EditText = findViewById(R.id.loginEmail)
        var loginPassword: EditText = findViewById(R.id.loginPassword)
        var clickHere: TextView = findViewById(R.id.clickHereSignUp)

        var btnLogin: Button = findViewById(R.id.btnSignUp)
        var intentCreateAccount = Intent(this, CreateAccount::class.java)

        loginEmail.setText(sentEmail)

        btnLogin.setOnClickListener {
            loginViewModel.email.value = loginEmail.text.toString()
            loginViewModel.password.value = loginPassword.text.toString()
            loginViewModel.login()
            this.startActivity(intentConnected)
        }




        clickHere.setOnClickListener{
            this.startActivity(intentCreateAccount)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
