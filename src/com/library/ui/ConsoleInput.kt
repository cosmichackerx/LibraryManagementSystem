package com.library.ui

object ConsoleInput {

    fun getIntInput(prompt: String, min: Int? = null, max: Int? = null): Int? {
        print(prompt)
        val input = readLine()?.toIntOrNull()
        return when {
            input != null && (min == null || input >= min) && (max == null || input <= max) -> input
            else -> {
                println("Invalid input. Please enter a number ${min?.let { "($it" } ?: ""}${max?.let { "..$it)" } ?: ""}")
                null
            }
        }
    }

    fun getStringInput(prompt: String, validator: (String) -> Boolean = { true }): String? {
        do {
            print(prompt)
            val input = readLine()
            if (input != null && validator(input)) return input
            println("Invalid input. Please try again.")
        } while (true)
    }

    fun getDoubleInput(prompt: String): Double? {
        print(prompt)
        return readLine()?.toDoubleOrNull()
    }

    fun confirmAction(prompt: String): Boolean {
        print("$prompt (y/n): ")
        return readLine()?.lowercase() == "y"
    }
}