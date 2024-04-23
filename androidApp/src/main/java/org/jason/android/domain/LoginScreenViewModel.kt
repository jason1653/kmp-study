package org.jason.android.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.jason.domain.auth.LoginValidator

class LoginScreenViewModel: ViewModel() {
    private val loginValidation: LoginValidator = LoginValidator()

    var formState by mutableStateOf(LoginFormState())

    fun loginDataChanged(email: String, passwd: String) {
        val emailError = (loginValidation.emailValidator(email) as ValidationResult.Failure).message
        val passwdError = (loginValidation.passwdValidator(passwd) as ValidationResult.Failure).message

        formState = LoginFormState(
            emailError = emailError,
            passwordError = passwdError
        )
    }
}