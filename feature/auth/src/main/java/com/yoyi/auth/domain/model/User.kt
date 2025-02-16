package com.yoyi.auth.domain.model

data class User(
    val id: String,
    val email: String,
    val name: String,
    val token: String
)

sealed class AuthResult {
    data class Success(val user: User) : AuthResult()
    data class Error(val message: String) : AuthResult()
}