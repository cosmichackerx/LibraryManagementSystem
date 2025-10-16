package com.library.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

object DateUtils {

    fun displayCurrentDate() {
        val today = LocalDate.now()
        println("Current Date: ${today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}")
    }

    fun addDays(startDate: LocalDate, days: Int): LocalDate {
        return startDate.plusDays(days.toLong())
    }

    fun calculateDaysBetween(start: LocalDate, end: LocalDate): Int {
        return Period.between(start, end).days
    }

    fun isValidDate(year: Int, month: Int, day: Int): Boolean {
        return try {
            LocalDate.of(year, month, day)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun parseDate(dateString: String): LocalDate? {
        return try {
            LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE)
        } catch (e: Exception) {
            null
        }
    }
}