package com.library.repository

import com.library.data.Book

class BookRepository {
    private val books = mutableListOf<Book>()

    fun save(book: Book) {
        books.add(book)
    }

    fun findById(id: String): Book? = books.find { it.id == id }

    fun findAll(): List<Book> = books.toList()

    fun delete(id: String): Boolean {
        val index = books.indexOfFirst { it.id == id }
        return if (index != -1) {
            books.removeAt(index)
            true
        } else false
    }

    fun updateAvailability(id: String, available: Boolean): Boolean {
        val book = findById(id)
        return if (book != null) {
            book.isAvailable = available
            true
        } else false
    }
}