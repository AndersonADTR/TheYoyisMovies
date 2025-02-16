package com.yoyi.auth.data.repository

/*
import com.yoyi.auth.data.local.AuthLocalDataSource
import com.yoyi.auth.data.mapper.toAuthResult
import com.yoyi.auth.data.mapper.toUser
import com.yoyi.auth.data.remote.AuthApi
import com.yoyi.auth.domain.model.AuthCredentials
import com.yoyi.auth.domain.model.AuthResult
import com.yoyi.auth.domain.model.User
import com.yoyi.auth.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val authLocalDataSource: AuthLocalDataSource
) : AuthRepository {

    override suspend fun login(credentials: AuthCredentials): AuthResult {
        return try {
            val response = authApi.login(credentials)
            response.toAuthResult().also { result ->
                if (result is AuthResult.Success) {
                    authLocalDataSource.saveUser(result.user)
                }
            }
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error occurred")
        }
    }

    override suspend fun register(
        email: String,
        password: String,
        name: String
    ): AuthResult {
        return try {
            val response = authApi.register(email, password, name)
            response.toAuthResult().also { result ->
                if (result is AuthResult.Success) {
                    authLocalDataSource.saveUser(result.user)
                }
            }
        } catch (e: Exception) {
            AuthResult.Error(e.message ?: "Unknown error occurred")
        }
    }

    override suspend fun logout() {
        authLocalDataSource.clearUser()
    }

    override fun getCurrentUser(): Flow<User?> {
        return authLocalDataSource.getUser().map { it?.toUser() }
    }

    override suspend fun updateUserToken(token: String) {
        authLocalDataSource.updateToken(token)
    }
}*/
