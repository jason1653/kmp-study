package org.jason.domain.auth

import org.jason.utils.validator.ValidatorResult

class LoginValidator {
    private val emailRegex =
        ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+").toRegex()

    fun emailValidator(email: String): ValidatorResult {
        return if(email.contains("@") && emailRegex.containsMatchIn(email)) {
            ValidatorResult()
        } else {
            ValidatorResult("이메일 형식이 올바르지 않습니다")
        }
    }

    fun passwdValidator(passwd: String): ValidatorResult {
        return when {
            passwd.length < 5 -> ValidatorResult("패스워드는 5자 이상이여야 합니다")
            else -> ValidatorResult()
        }
    }
}