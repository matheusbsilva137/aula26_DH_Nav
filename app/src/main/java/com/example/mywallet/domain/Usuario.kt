package com.example.mywallet.domain

import java.io.Serializable

class Usuario(var username: String, var password: String) : Serializable {
    override fun toString(): String {
        return "Usuario(username='$username', password='$password')"
    }
}