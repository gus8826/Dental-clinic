package com.leaftware.dental.clinic.views.singup.changePassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leaftware.dental.clinic.utils.isValidEmail

class ChangePasswordViewModel: ViewModel()  {

    val isEmailEmpty = MutableLiveData<Boolean>()
    val isEmailFormat = MutableLiveData<Boolean>()

    val SendChangePasswordIsSuccessful = MutableLiveData<Boolean>()
    fun setSendChangePassword(email: String) {
        if (email.isEmpty()) {
            isEmailEmpty.value = false
        } else if (!email.isValidEmail()) {
            isEmailFormat.value = false
        } else {
            SendChangePasswordIsSuccessful.value = true
        }
    }
}