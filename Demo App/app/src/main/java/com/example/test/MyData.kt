package com.example.test

object MyData
{
    var users = ArrayList<User>()
    var logUser = User("","","","","")
}

class User(var name: String, var email: String, var password: String, var country:String, var role: String)
{

}