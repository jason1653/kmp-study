package org.jason.android.domain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.jason.domain.admin.users.request.CreateUserRequest
import org.jason.domain.auth.LoginValidator
import org.jason.service.MemberService


class LoginScreenViewModel: ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
    var emailMessage by mutableStateOf("")
    var passwordMessage by mutableStateOf("")
    var isValid by mutableStateOf(false)
    var isLoading by mutableStateOf(false)

    private val loginValidator = LoginValidator()
    private val memberService = MemberService()


    fun updateEmail(newEmail: String) {
        email = newEmail
    }


    fun validateEmail() {
        Log.d("TEST", "테스트")
        isValid = false
        Log.d("TEST", email)
        val validator = loginValidator.emailValidator(email)
        Log.d("TEST", validator.message)
        emailMessage = validator.message
    }

    fun validatePassword() {
        isValid = false
        val validator = loginValidator.passwdValidator(password)
        passwordMessage = validator.message
    }

    fun createUserProcess() {
        viewModelScope.launch {
            val createUserRequest = CreateUserRequest(
                userName = "테스트23",
                phoneNumber = "010-7442-2662",
                gender = "M",
                birthDate = "19810627",
                userId = "saga165181111",
                nickName = "테스트2727272",
                userPwd = "Test!$2233",
                userPwdConfirm = "Test!$2233",
                email = email  // Use the mutable state directly
            )
            isLoading = true
            try {
                val response = memberService.createUser(createUserRequest)
                // Process response here
            } catch (error: Exception) {
                emailMessage = "Failed to create user: ${error.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun loginProcess() {
        isLoading = true
        viewModelScope.launch {
            try {
                val exists = memberService.existsUserId(userId = "test")
                // Handle 'exists' response appropriately
            } catch (error: Exception) {
                emailMessage = "Login failed: ${error.localizedMessage}"
            }

            validateEmail()
            validatePassword()

            if (!isValid) {
                isLoading = false
                emailMessage = "Validation error"
                return@launch
            }

            // Proceed with further login logic if validation passes
            isLoading = false
        }
    }
}