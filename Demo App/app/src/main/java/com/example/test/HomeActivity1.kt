package com.example.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity1 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val data = findViewById<TextView>(R.id.data)
        val logOut = findViewById<Button>(R.id.logOut)
        data.text = "${MyData.logUser.name}  ${MyData.logUser.country} ${MyData.logUser.role}"
        logOut.setOnClickListener{
            MyData.logUser.name = ""
            MyData.logUser.email = ""
            MyData.logUser.password = ""
            MyData.logUser.country = ""
            MyData.logUser.role = ""
            finish()
        }

    }
}