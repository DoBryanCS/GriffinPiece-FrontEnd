package com.example.frontendandroid_projet3_dokhoa

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {

    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar = supportActionBar!!
        actionBar.title = "Bienvenue sur Griffin Piece"
        actionBar.setBackgroundDrawable(ColorDrawable(Color.parseColor("#040404")))

        var login = findViewById<Button>(R.id.btnLogin)
        login.setOnClickListener {
            startActivity(Intent(this, ForgotpasswordActivity::class.java))
        }
    }
}