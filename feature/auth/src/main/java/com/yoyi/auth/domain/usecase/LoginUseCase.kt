package com.yoyi.auth.domain.usecase

import com.example.movieapp.core.analytics.AnalyticsTracker
import com.yoyi.auth.domain.model.AuthCredentials
import com.yoyi.auth.domain.model.AuthResult
import com.yoyi.auth.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val analyticsTracker: AnalyticsTracker
) {
    suspend operator fun invoke(email: String, password: String): AuthResult {
        val credentials = AuthCredentials(email, password)
        val result = authRepository.login(credentials)

        when (result) {
            is AuthResult.Success -> {
                analyticsTracker.trackEvent("login_success")
            }
            is AuthResult.Error -> {
                analyticsTracker.trackEvent("login_error", mapOf("error" to result.message))
            }
        }

        return result
    }
}