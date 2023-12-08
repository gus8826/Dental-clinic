package com.leaftware.dental.clinic.ui.views.singup.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leaftware.dental.clinic.core.ApiClient
import com.leaftware.dental.clinic.domain.LoginUseCase
import com.leaftware.dental.clinic.utils.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val apiClient: ApiClient
) : ViewModel() {

    //text email empty
    private val _emailEmptyFieldError = MutableLiveData<Boolean>()
    val emailEmptyFieldError: LiveData<Boolean> get() = _emailEmptyFieldError

    //text password empty
    private val _passwordEmptyFieldError = MutableLiveData<Boolean>()
    val passwordEmptyFieldError: LiveData<Boolean> get() = _passwordEmptyFieldError

    // correo mal formado
    private val _emailFormatError = MutableLiveData<Boolean>()
    val emailFormatError: LiveData<Boolean> get() = _emailFormatError

    // LiveData para indicar el éxito del inicio de sesión
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    fun authenticate(username: String, password: String) {
        if (username.isBlank()) {
            _emailEmptyFieldError.value = true
        } else if (password.isBlank()) {
            _passwordEmptyFieldError.value = true
        } else if (!username.isValidEmail()) {
            _emailFormatError.value = true
        }else{
            viewModelScope.launch {
                try {
                    val isSuccess = apiClient.apiService.login(username, password).isSuccessful

                    _loginSuccess.value = isSuccess
                } catch (e: Exception) {
                    _loginSuccess.value = false
                }
            }
        }
    }

    fun resetEmptyFieldsError() {
        _emailEmptyFieldError.value = false
    }

    fun resetEmailFieldsError() {
        _emailFormatError.value = false
    }
}