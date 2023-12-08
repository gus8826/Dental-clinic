package com.leaftware.dental.clinic.ui.views.singup.Splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _navigateToNextScreen = MutableLiveData<Boolean>()
    val navigateToNextScreen: LiveData<Boolean> get() = _navigateToNextScreen

    init {
        viewModelScope.launch {
            delay(SPLASH_DELAY_MS)
            _navigateToNextScreen.value = true
        }
    }

    fun onNavigationComplete() {

    }

    companion object {
        private const val SPLASH_DELAY_MS = 2000L
    }
}