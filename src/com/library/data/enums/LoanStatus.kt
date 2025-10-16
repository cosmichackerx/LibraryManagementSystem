package com.library.data.enums

enum class LoanStatus {
    ACTIVE,
    RETURNED,
    OVERDUE,
    LOST,
    RESERVED;

    fun isActiveLoan(): Boolean = this == ACTIVE || this == OVERDUE
}