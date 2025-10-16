package com.library.data

import com.library.data.enums.LoanStatus
import java.time.LocalDate
import java.time.Period

class Loan(
    val bookId: String,
    val memberId: String,
    val loanDate: LocalDate,
    var dueDate: LocalDate,
    var returnDate: LocalDate? = null,
    var fineAmount: Double = 0.0,
    var status: LoanStatus = LoanStatus.ACTIVE
) {
    fun isOverdue(today: LocalDate): Boolean {
        return status == LoanStatus.ACTIVE && today.isAfter(dueDate)
    }

    fun calculateFine(today: LocalDate): Double {
        if (!isOverdue(today)) return 0.0

        val overdueDays = Period.between(dueDate, today).days
        val dailyFine = 1.0
        return overdueDays * dailyFine.toDouble()
    }

    fun returnBook(returnDate: LocalDate) {
        this.returnDate = returnDate
        status = LoanStatus.RETURNED
    }
}