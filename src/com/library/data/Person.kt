package com.library.data

abstract class Person(
    val id: String,
    val name: String,
    val email: String,
    var isActive: Boolean = true
) {
    // Secondary constructor
    constructor(name: String, email: String) : this(generateId(), name, email)

    companion object {
        private var idCounter = 0
        fun generateId(): String = "P${++idCounter}"
    }

    open fun displayInfo() {
        println("ID: $id, Name: $name, Email: $email, Active: $isActive")
    }

    fun validateEmail(): Boolean {
        return email.contains("@") && email.contains(".")
    }

    open fun canBorrowBooks(): Boolean = isActive && validateEmail()
}