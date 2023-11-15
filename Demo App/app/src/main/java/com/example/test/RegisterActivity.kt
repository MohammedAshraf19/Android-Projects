package com.example.test

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        val name = findViewById<EditText>(R.id.registerName)
        val email = findViewById<EditText>(R.id.registerEmail)
        val password = findViewById<EditText>(R.id.registerPassword)
        val confirmPassword = findViewById<EditText>(R.id.registerConfirmPassword)
        val country = findViewById<Spinner>(R.id.countrySpinner)
        val role = findViewById<Spinner>(R.id.roleSpinner)
        val signUp = findViewById<Button>(R.id.signUp)
        val text = findViewById<TextView>(R.id.toLogin)
        text.setOnClickListener{
            finish()
        }
        signUp.setOnClickListener{

            if (password.text.toString() != confirmPassword.text.toString()){
                Toast.makeText(this,"Password Not Identical",Toast.LENGTH_SHORT).show()
            }
            else if (name.text.toString() != "" && email.text.toString() != "" && password.text.toString() != "" && confirmPassword.text.toString() != "")
            {
                MyData.users.add(
                    User(name.text.toString()
                        ,email.text.toString(),
                        password.text.toString(),
                        country.selectedItem.toString(),
                        role.selectedItem.toString()
                    )
                )
                Toast.makeText(this,"Success Sign Up",Toast.LENGTH_SHORT).show()
                finish()
            }
            else
            {
                Toast.makeText(this,"Fill All Data",Toast.LENGTH_SHORT).show()
            }
        }
    }
}