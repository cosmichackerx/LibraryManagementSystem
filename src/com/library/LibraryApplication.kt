package com.library

import com.library.services.LibraryService
import com.library.ui.MenuSystem
import com.library.utils.DateUtils

fun main() {
    val libraryService = LibraryService()
    val menuSystem = MenuSystem(libraryService)

    // Initialize sample data
    libraryService.initializeSampleData()

    println("=== Welcome to Library Management System ===")
    DateUtils.displayCurrentDate()

    // Main program loop demonstrating while loop and break/continue
    var running = true
    while (running) {
        menuSystem.showMainMenu()
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> menuSystem.handleMemberOperations()
            2 -> menuSystem.handleBookOperations()
            3 -> menuSystem.handleLoanOperations()
            4 -> menuSystem.showReports()
            5 -> {
                println("Thank you for using Library Management System!")
                running = false
                break
            }
            else -> {
                println("Invalid choice. Please try again.")
                continue
            }
        }
    }
}