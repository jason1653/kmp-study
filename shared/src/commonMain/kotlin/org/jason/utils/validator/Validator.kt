package org.jason.utils.validator

interface Validator<T> {
    fun validator(value: T)
}