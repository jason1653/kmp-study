package org.jason.utils.ktor

import kotlinx.serialization.SerialInfo
import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse<T>(
    val code: String,
    val message: String,
    val status: Int,
    val body: T
)
