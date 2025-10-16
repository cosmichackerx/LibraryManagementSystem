package com.library.services

import com.library.data.enums.BookGenre

class SearchService(private val libraryService: LibraryService) {

    fun searchBooksByAuthor(author: String): List<String> {
        return libraryService.books
            .filter { it.author.contains(author, ignoreCase = true) }
            .map { "${it.title} by ${it.author}" }
    }

    fun searchBooksByGenre(genre: String): List<String> {
        val bookGenre = BookGenre.fromString(genre)
        return if (bookGenre != null) {
            libraryService.books
                .filter { it.genre == bookGenre }
                .map { it.title }
        } else emptyList()
    }

    fun advancedSearch(title: String? = null, author: String? = null, availableOnly: Boolean = false): List<String> {
        return libraryService.books
            .filter { book ->
                (title == null || book.title.contains(title, ignoreCase = true)) &&
                        (author == null || book.author.contains(author, ignoreCase = true)) &&
                        (!availableOnly || book.isAvailable)
            }
            .map { it.title }
    }
}