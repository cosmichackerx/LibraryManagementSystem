package com.library.utils

object StringUtils {

    fun capitalize(text: String): String {
        return text.split(" ").joinToString(" ") {
            it.replaceFirstChar { char -> char.uppercaseChar() }
        }
    }

    fun formatISBN(isbn: String): String {
        val clean = isbn.replace("-", "").replace(" ", "")
        return if (clean.length == 13) {
            clean.chunked(1).chunked(3).joinToString("-") { it.joinToString("") }
                .dropLast(1) + "-" + clean.takeLast(1)
        } else isbn
    }

    fun truncate(text: String, maxLength: Int): String {
        return if (text.length > maxLength) {
            text.take(maxLength - 3) + "..."
        } else text
    }

    fun isValidName(name: String): Boolean {
        return name.length in 2..50 && name.all { it.isLetterOrDigit() || it.isWhitespace() }
    }
}