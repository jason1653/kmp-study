package org.jason.utils.ktor

class ApiException(code: String, status: Int, message: String) : Exception(message) {}