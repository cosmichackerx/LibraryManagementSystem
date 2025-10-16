package com.library.data

class Librarian(
    id: String,
    name: String,
    email: String,
    val adminLevel: Int = 1
) : Person(id, name, email) {

    fun addBook(book: Book): Boolean {
        // Admin privilege check
        return adminLevel >= 1
    }

    fun removeBook(bookId: String): Boolean {
        return adminLevel >= 2
    }

    fun approveMembership(member: Member): Boolean {
        member.isActive = true
        return true
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Admin Level: $adminLevel")
    }
}