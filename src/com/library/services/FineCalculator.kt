package com.library.services

import com.library.data.Loan
import java.time.LocalDate

class FineCalculator {

    fun calculateOverdueFine(overdueDays: Int, membershipMultiplier: Double): Double {
        val baseFine = 1.0
        return (overdueDays * baseFine * membershipMultiplier).coerceAtLeast(0.0)
    }

    fun calculateTotalFines(loans: List<Loan>, today: LocalDate): Double {
        return loans.sumOf { loan -> loan.calculateFine(today) }
    }
}