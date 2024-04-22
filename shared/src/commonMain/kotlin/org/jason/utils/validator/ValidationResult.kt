package org.jason.utils.validator

sealed class ValidationResult {
    object Success: ValidationResult()

    data class Failure(val message: String) : ValidationResult()
}