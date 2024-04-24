package org.jason.utils.ktor

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ErrorResponse(
    val code: String,
    @Serializable(with = MessageSerializer::class)
    val message: String,
    val status: Int,
    val body: String?
)
