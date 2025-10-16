package com.library.ui

import com.library.services.LibraryService

class Reports(private val libraryService: LibraryService) {

    fun generateBookReport() {
        val available = libraryService.getAvailableBooks()
        val total = libraryService.getAllBooksCount()

        println("\n=== Book Report ===")
        println("Total Books: $total")
        println("Available: ${available.size}")
        println("Unavailable: ${total - available.size}")

        // Fixed: Use explicit Boolean condition instead of range comparison
        val cutoffYear = 2015
        val recentBooks = available.count { it.publicationYear >= cutoffYear }
        println("Books published since $cutoffYear: $recentBooks")
    }

    fun generateMemberReport() {
        val activeMembers = libraryService.getActiveMembers()
        println("\n=== Member Report ===")
        println("Active Members: ${activeMembers.size}")

        // Group by membership type using when for demonstration
        val typeCount = activeMembers.groupBy { it.membershipType }
        typeCount.forEach { (type, members) ->
            println("${type.name}: ${members.size} members")
        }

        // Demonstrate when expression
        val mostActive = activeMembers.maxByOrNull { it.borrowedBooks.size }
        mostActive?.let {
            println("Most active member: ${it.name} with ${it.borrowedBooks.size} books")
        }
    }

    fun generateLoanReport() {
        println("\n=== Loan Report ===")
        val totalLoans = libraryService.loans.size
        println("Total Loans: $totalLoans")

        // Demonstrate if-else with Boolean conditions
        val overdueLoans = libraryService.loans.filter { loan ->
            loan.status == com.library.data.enums.LoanStatus.ACTIVE &&
                    java.time.LocalDate.now().isAfter(loan.dueDate)
        }

        if (overdueLoans.isNotEmpty()) {
            println("Overdue loans: ${overdueLoans.size}")
            overdueLoans.forEach { println("Loan overdue: ${it.bookId}") }
        } else {
            println("No overdue loans")
        }
    }
}