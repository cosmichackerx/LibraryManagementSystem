package com.library.utils

object Constants {
    const val MAX_LOAN_DAYS = 30
    const val DAILY_FINE_RATE = 1.0
    const val MAX_BOOK_PRICE = 1000.0
    const val MIN_BOOK_PRICE = 0.01

    object Messages {
        const val BOOK_NOT_FOUND = "Book not found"
        const val MEMBER_NOT_ELIGIBLE = "Member not eligible to borrow"
        const val INVALID_ISBN = "Invalid ISBN format"
        const val SUCCESS_BORROW = "Book borrowed successfully"
    }
}