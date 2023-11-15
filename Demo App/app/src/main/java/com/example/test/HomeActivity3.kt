package com.example.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home3)

        val data = findViewById<TextView>(R.id.data3)
        val logOut = findViewById<Button>(R.id.logOut3)
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