package com.example.kotlinloginmvvm.network

data class LoginResponse(
    val token: String?
) {
    override fun toString(): String {
        return "LoginResponse(token=$token)"
    }
}