package com.library.ui

import com.library.services.LibraryService

class MenuSystem(private val libraryService: LibraryService) {

    fun showMainMenu() {
        println("\n=== Main Menu ===")
        println("1. Member Operations")
        println("2. Book Operations")
        println("3. Loan Operations")
        println("4. Reports")
        println("5. Exit")
        print("Choose option: ")
    }

    fun handleMemberOperations() {
        var running = true
        while (running) {
            println("\n=== Member Menu ===")
            println("1. Add Member")
            println("2. Search Members")
            println("3. View All Members")
            println("4. Back to Main Menu")

            when (readLine()?.toIntOrNull()) {
                1 -> addMember()
                2 -> searchMembers()
                3 -> viewAllMembers()
                4 -> running = false
                else -> println("Invalid option")
            }
        }
    }

    private fun addMember() {
        print("Enter name: ")
        val name = readLine() ?: return

        print("Enter email: ")
        val email = readLine() ?: return

        print("Enter membership type (BASIC/PREMIUM/STUDENT/SENIOR): ")
        val type = readLine()?.uppercase()

        // Create and add member (simplified for demo)
        println("Member added successfully!")
    }

    private fun searchMembers() {
        print("Enter member name to search: ")
        val searchTerm = readLine() ?: ""
        val results = libraryService.members.filter { it.name.contains(searchTerm, ignoreCase = true) }
        results.forEach { println(it.name) }
    }

    private fun viewAllMembers() {
        libraryService.getActiveMembers().forEach {
            println("${it.id}: ${it.name} - ${it.getMembershipDetails()}")
        }
    }

    fun handleBookOperations() {
        // Similar structure for book operations
        println("Book operations menu - implement add, search, view books")
    }

    fun handleLoanOperations() {
        // Loan operations menu
        println("Loan operations menu - implement borrow, return, view loans")
    }

    fun showReports() {
        println("\n=== Reports ===")
        println("Total Books: ${libraryService.getAllBooksCount()}")
        println("Available Books: ${libraryService.getAvailableBooks().size}")
        // More report functions
    }
}