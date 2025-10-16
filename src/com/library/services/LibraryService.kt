package com.library.services

import com.library.data.Book
import com.library.data.Member
import com.library.data.Librarian
import com.library.data.Loan
import com.library.data.enums.BookGenre
import com.library.data.enums.MembershipType
import com.library.repository.BookRepository
import com.library.repository.MemberRepository
import com.library.repository.LoanRepository

class LibraryService {
    private val bookRepository = BookRepository()
    private val memberRepository = MemberRepository()
    private val loanRepository = LoanRepository()
    private val librarian = Librarian("L1", "Admin Librarian", "admin@library.com", 3)
    val books: List<Book> get() = bookRepository.findAll()
    val members: List<Member> get() = memberRepository.getAllMembers()
    val loans: List<Loan> get() = loanRepository.getAllLoans()

    fun addBook(book: Book) {
        if (librarian.addBook(book)) {
            bookRepository.save(book)
        }
    }

    fun addMember(member: Member) {
        if (librarian.approveMembership(member)) {
            memberRepository.save(member)
        }
    }

    fun findBookByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, ignoreCase = true) }
    }

    fun findMemberByName(name: String): List<Member> {
        return memberRepository.findByName(name)
    }

    fun processLoan(bookId: String, memberId: String): Boolean {
        val book = books.find { it.id == bookId && it.isAvailable }
        val member = members.find { it.id == memberId && it.canBorrowBooks() }

        return if (book != null && member != null) {
            book.isAvailable = false
            member.borrowBook(bookId)
            true
        } else false
    }

    fun initializeSampleData() {
        val sampleBooks = listOf(
            Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 15.99, BookGenre.FICTION),
            Book("1984", "George Orwell", "978-0451524935", 12.99, BookGenre.FICTION),
            Book("Clean Code", "Robert C. Martin", "978-0132350884", 45.99, BookGenre.TECH)
        )
        sampleBooks.forEach { addBook(it) }

        val sampleMembers = listOf(
            Member("John Doe", "john@example.com", MembershipType.PREMIUM),
            Member("Jane Smith", "jane@example.com", MembershipType.BASIC)
        )
        sampleMembers.forEach { addMember(it) }
    }

    fun getAvailableBooks(): List<Book> = books.filter { it.isAvailable }
    fun getAllBooksCount(): Int = books.size
    fun getActiveMembers(): List<Member> = memberRepository.findActiveMembers()
}