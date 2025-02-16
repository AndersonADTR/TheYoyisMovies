package com.yoyi.auth.domain.repository

import com.yoyi.auth.domain.model.AuthCredentials
import com.yoyi.auth.domain.model.AuthResult
import com.yoyi.auth.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(credentials: AuthCredentials): AuthResult
    suspend fun register(email: String, password: String, name: String): AuthResult
    suspend fun logout()
    fun getCurrentUser(): Flow<User?>
    suspend fun updateUserToken(token: String)
}