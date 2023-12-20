package com.example.test
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val email = findViewById<EditText>(R.id.loginEmail)
        val password = findViewById<EditText>(R.id.loginPassword)
        val logIn = findViewById<Button>(R.id.logIn)
        val text = findViewById<TextView>(R.id.toRegister)

        val registerIntent = Intent(this, RegisterActivity::class.java)
        text.setOnClickListener{
            startActivity(registerIntent)
        }


        logIn.setOnClickListener{
            val emailText = email.text.toString()
            val passwordText = password.text.toString()
            var logINDone = false
            if (emailText != "" && passwordText != "")
            {
                for (user in MyData.users)
                {
                    if (emailText == user.email && passwordText == user.password)
                    {
                        MyData.logUser.name = user.name
                        MyData.logUser.email = user.email
                        MyData.logUser.password = user.password
                        MyData.logUser.country = user.country
                        MyData.logUser.role = user.role
                        logINDone = true

                        val homeIntent = Intent(this, HomeActivity1::class.java)
                        startActivity(homeIntent)
                        break
                    }
                }
                if(!logINDone)
                {
                    Toast.makeText(this,"Fail",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Fill All Data",Toast.LENGTH_SHORT).show()
            }
        }
    }
}