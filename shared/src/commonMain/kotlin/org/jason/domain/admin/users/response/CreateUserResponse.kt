package org.jason.domain.admin.users.response

import kotlinx.serialization.Serializable


@Serializable
data class CreateUserResponse(
    val id: String,
    val userId: String,
    val userName: String,
    val token: String,
    val refreshToken: String,
    val key: String
)
