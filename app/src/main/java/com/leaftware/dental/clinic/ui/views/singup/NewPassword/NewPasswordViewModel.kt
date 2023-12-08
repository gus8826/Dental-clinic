package com.leaftware.dental.clinic.ui.views.singup.NewPassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leaftware.dental.clinic.utils.isValidEmail

class NewPasswordViewModel : ViewModel(){

    val isPasswordEmpty = MutableLiveData<Boolean>()
    val isRepeatPasswordEmpty = MutableLiveData<Boolean>()

    val SendNewPasswordIsSuccessful = MutableLiveData<Boolean>()
    fun setSendNewPassword(password: String, repeatPassword:String) {
        if (password.isEmpty()) {
            isPasswordEmpty.value = false
        } else if (repeatPassword.isEmpty()) {
            isRepeatPasswordEmpty.value = false
        } else {
            SendNewPasswordIsSuccessful.value = true
        }
    }
}