package com.yoyi.auth.presentation.state

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val isSuccess: Boolean = false
)

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    object LoginClicked : LoginEvent()
    object NavigateToRegister : LoginEvent()
    object DismissError : LoginEvent()
}

sealed class LoginEffect {
    object NavigateToHome : LoginEffect()
    object NavigateToRegister : LoginEffect()
    data class ShowError(val message: String) : LoginEffect()
}