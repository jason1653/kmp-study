package org.jason.domain.auth

import org.jason.utils.validator.ValidationResult

class LoginValidator {
    private val emailRegex =
        ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+").toRegex()

    fun emailValidator(email: String): ValidationResult {
        return if(email.contains("@") && emailRegex.containsMatchIn(email)) {
            ValidationResult.Success
        } else {
            ValidationResult.Failure("이메일 형식이 올바르지 않습니다")
        }
    }

    fun passwdValidator(passwd: String): ValidationResult {
        return when {
            passwd.length < 5 -> ValidationResult.Failure("5자 이상 입력해야됩니다")

            else -> ValidationResult.Success
        }
    }
}