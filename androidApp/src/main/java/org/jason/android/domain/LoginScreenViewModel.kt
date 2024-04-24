package org.jason.android.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.jason.domain.auth.LoginValidator

class LoginScreenViewModel: ViewModel() {
    private val loginValidation: LoginValidator = LoginValidator()

    var formState by mutableStateOf(LoginFormState())

}