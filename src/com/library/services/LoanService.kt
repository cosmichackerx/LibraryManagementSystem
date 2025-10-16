package com.library.services

import com.library.data.Loan
import com.library.utils.DateUtils
import java.time.LocalDate

class LoanService(private val libraryService: LibraryService) {

    fun createLoan(bookId: String, memberId: String): Loan? {
        if (libraryService.processLoan(bookId, memberId)) {
            val loanDate = LocalDate.now()
            val dueDate = DateUtils.addDays(loanDate, 14)
            return Loan(bookId, memberId, loanDate, dueDate)
        }
        return null
    }

    fun processReturn(loanId: String, returnDate: LocalDate) {
        // Implementation for returning books and calculating fines
    }

    fun getOverdueLoans(): List<Loan> {
        val today = LocalDate.now()
        return libraryService.loans.filter { it.isOverdue(today) }
    }
}