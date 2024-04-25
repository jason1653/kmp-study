package org.jason.utils.ktor

import io.ktor.http.HttpStatusCode

class ErrorResponseException(
    val code: String?,
    override val message: String?,
    val status: HttpStatusCode,
    val body: String?
) : Exception(message = message) {
}