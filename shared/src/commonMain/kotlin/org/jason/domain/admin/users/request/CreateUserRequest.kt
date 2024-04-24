package org.jason.domain.admin.users.request

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    val userName: String,
    val phoneNumber: String,
    val gender: String,
    val birthDate: String,
    val userId: String,
    val nickName: String,
    val userPwd: String,
    val userPwdConfirm: String,
    val email: String
)
