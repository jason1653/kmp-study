package org.jason.android.domain

data class LoginFormState(
    val emailError: String? = null,
    val passwordError: String? = null
) {
}