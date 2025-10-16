package com.library.data

import com.library.data.enums.MembershipType

class Member(
    id: String,
    name: String,
    email: String,
    val membershipType: MembershipType,
    var borrowedBooks: MutableList<String> = mutableListOf()
) : Person(id, name, email) {

    constructor(name: String, email: String, membershipType: MembershipType) :
            this(generateMemberId(), name, email, membershipType)

    companion object {
        private var memberIdCounter = 1000
        fun generateMemberId(): String = "M${++memberIdCounter}"
    }

    fun borrowBook(bookId: String): Boolean {
        return if (canBorrowMoreBooks() && super.canBorrowBooks()) {
            borrowedBooks.add(bookId)
            true
        } else false
    }

    fun returnBook(bookId: String): Boolean {
        return borrowedBooks.remove(bookId)
    }

    private fun canBorrowMoreBooks(): Boolean {
        return borrowedBooks.size < membershipType.loanLimit
    }

    override fun canBorrowBooks(): Boolean {
        return super.canBorrowBooks() && canBorrowMoreBooks()
    }

    fun getMembershipDetails(): String {
        return "Type: ${membershipType.name}, Loan Limit: ${membershipType.loanLimit}"
    }
}