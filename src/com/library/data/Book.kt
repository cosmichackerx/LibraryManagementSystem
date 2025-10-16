package com.library.data

import com.library.data.enums.BookGenre

class Book(
    val id: String,
    val title: String,
    val author: String,
    val isbn: String,
    var price: Double,
    var isAvailable: Boolean = true, // Make sure this is var
    val genre: BookGenre,
    var publicationYear: Int = 0
) {
    private var _loanCount = 0
    val loanCount: Int get() = _loanCount

    constructor(title: String, author: String, isbn: String, price: Double, genre: BookGenre) :
            this(generateId(), title, author, isbn, price, true, genre)

    companion object {
        private var idCounter = 0
        fun generateId(): String = "B${++idCounter}"
    }

    fun checkOut(): Boolean {
        return if (isAvailable) {
            isAvailable = false
            _loanCount++
            true
        } else false
    }

    fun checkIn() {
        isAvailable = true
    }

    fun calculateRentalFee(days: Int): Double {
        val baseRate = when (genre) {
            BookGenre.TECH, BookGenre.SCIENCE -> 2.5
            else -> 1.5
        }
        return baseRate * days
    }

    override fun toString(): String {
        return "Book(id='$id', title='$title', author='$author', available=$isAvailable, genre=$genre)"
    }
}