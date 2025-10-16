package com.library.repository

import com.library.data.Loan
import com.library.data.enums.LoanStatus
import java.time.LocalDate
import java.time.Period
import kotlin.hashCode

class LoanRepository {
    private val loans = mutableListOf<Loan>()

    fun save(loan: Loan): Loan {
        loans.add(loan)
        return loan
    }

    fun findById(id: String): Loan? {
        // Using hashCode for demo - in real app use proper ID field
        return loans.find { loan -> loan.hashCode().toString() == id }
    }

    fun findByBookId(bookId: String): List<Loan> {
        return loans.filter { it.bookId == bookId }
    }

    fun findByMemberId(memberId: String): List<Loan> {
        return loans.filter { it.memberId == memberId }
    }

    fun findActiveLoans(): List<Loan> {
        return loans.filter { it.status == LoanStatus.ACTIVE }
    }

    fun findOverdueLoans(today: LocalDate): List<Loan> {
        return loans.filter {
            it.status == LoanStatus.ACTIVE && today.isAfter(it.dueDate)
        }
    }

    fun updateLoanStatus(loanId: String, status: LoanStatus): Boolean {
        val loan = findById(loanId)
        return if (loan != null) {
            loan.status = status
            true
        } else false
    }

    fun updateReturnDate(loanId: String, returnDate: LocalDate): Boolean {
        val loan = findById(loanId)
        return if (loan != null) {
            loan.returnDate = returnDate
            loan.status = LoanStatus.RETURNED
            true
        } else false
    }

    fun calculateMemberFines(memberId: String, today: LocalDate): Double {
        val memberLoans = findByMemberId(memberId)
        return memberLoans.sumOf { loan ->
            if (loan.status == LoanStatus.ACTIVE && today.isAfter(loan.dueDate)) {
                val overdueDays = Period.between(loan.dueDate, today).days
                overdueDays * 1.0
            } else 0.0
        }
    }

    fun delete(loanId: String): Boolean {
        val index = loans.indexOfFirst { it.hashCode().toString() == loanId }
        return if (index != -1) {
            loans.removeAt(index)
            true
        } else false
    }

    fun getAllLoans(): List<Loan> = loans.toList()

    fun getLoanStatistics(): Map<LoanStatus, Int> {
        return loans.groupingBy { it.status }.eachCount()
    }

    fun getLoansInDateRange(startDate: LocalDate, endDate: LocalDate): List<Loan> {
        return loans.filter { loan ->
            loan.loanDate in startDate..endDate ||
                    (loan.returnDate != null && loan.returnDate!! in startDate..endDate)
        }
    }
}