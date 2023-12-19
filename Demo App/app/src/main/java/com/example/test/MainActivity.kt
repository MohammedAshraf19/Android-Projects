package com.example.test

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer

import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        val intern = Intent(this, LoginActivity::class.java)
        Timer().schedule(2000) {
            startActivity(intern)
            finish()
        }
    }
}