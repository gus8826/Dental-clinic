package com.leaftware.dental.clinic.views.singup.Splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    private val _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin get() = _navigateToLogin

    fun onSplashTimeout() {
        _navigateToLogin.value = true
    }
}