package com.leaftware.dental.clinic.views.singup.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leaftware.dental.clinic.utils.isValidEmail

class LoginViewModel : ViewModel() {

    //val userLoginModel = MutableLiveData<UserLoginModel>()

    val isEmailEmpty = MutableLiveData<Boolean>()
    val isPasswordEmpty = MutableLiveData<Boolean>()
    val isEmailFormat = MutableLiveData<Boolean>()

    val loginIsSuccessful = MutableLiveData<Boolean>()
    fun setLogin(email: String, password: String) {
        if (email.isEmpty()) {
            isEmailEmpty.value = false
        } else if (password.isEmpty()) {
            isPasswordEmpty.value = false
        } else if (!email.isValidEmail()) {
            isEmailFormat.value = false
        } else {
            loginIsSuccessful.value = true
        }
    }
}