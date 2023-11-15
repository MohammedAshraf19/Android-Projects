package com.example.test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        val data = findViewById<TextView>(R.id.data2)
        val logOut = findViewById<Button>(R.id.logOut2)
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