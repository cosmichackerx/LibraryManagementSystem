package com.library.services

class ValidationService {

    fun validateISBN(isbn: String): Boolean {
        val cleanISBN = isbn.replace("-", "").replace(" ", "")
        return cleanISBN.length == 13 && cleanISBN.all { it.isDigit() }
    }

    fun validateEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")
        return emailRegex.matches(email)
    }

    fun validatePrice(price: Double): Boolean = price > 0.0

    fun <T> validateInput(input: T?, validator: (T) -> Boolean, errorMessage: String): T? {
        return if (input != null && validator(input)) input else {
            println(errorMessage)
            null
        }
    }
}