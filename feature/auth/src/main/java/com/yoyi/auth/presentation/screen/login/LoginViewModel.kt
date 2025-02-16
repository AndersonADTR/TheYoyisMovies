package com.yoyi.auth.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoyi.auth.domain.model.AuthResult
import com.yoyi.auth.domain.usecase.LoginUseCase
import com.yoyi.auth.presentation.state.LoginEffect
import com.yoyi.auth.presentation.state.LoginEvent
import com.yoyi.auth.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChanged -> {
                _state.update { it.copy(email = event.email) }
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password) }
            }
            LoginEvent.LoginClicked -> {
                login()
            }
            LoginEvent.NavigateToRegister -> {
                viewModelScope.launch {
                    _effect.emit(LoginEffect.NavigateToRegister)
                }
            }
            LoginEvent.DismissError -> {
                _state.update { it.copy(error = null) }
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            when (val result = loginUseCase(state.value.email, state.value.password)) {
                is AuthResult.Success -> {
                    _state.update { it.copy(isLoading = false, isSuccess = true) }
                    _effect.emit(LoginEffect.NavigateToHome)
                }
                is AuthResult.Error -> {
                    _state.update {
                        it.copy(isLoading = false, error = result.message)
                    }
                    _effect.emit(LoginEffect.ShowError(result.message))
                }
            }
        }
    }
}