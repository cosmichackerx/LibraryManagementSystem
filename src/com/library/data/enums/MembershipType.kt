package com.library.data.enums

enum class MembershipType(val loanLimit: Int, val fineMultiplier: Double) {
    BASIC(3, 1.0),
    PREMIUM(10, 0.8),
    STUDENT(5, 0.9),
    SENIOR(8, 0.7);

    fun calculateMaxLoanDays(): Int = when (this) {
        BASIC -> 14
        PREMIUM -> 30
        STUDENT -> 21
        SENIOR -> 28
    }
}