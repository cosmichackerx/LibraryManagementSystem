package com.library.data.enums

enum class BookGenre(val displayName: String) {
    FICTION("Fiction"),
    NON_FICTION("Non-Fiction"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    ROMANCE("Romance"),
    TECH("Technology");

    companion object {
        fun fromString(genreName: String): BookGenre? {
            return values().find { it.name.equals(genreName, ignoreCase = true) }
        }
    }
}