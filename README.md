# 📚 Kotlin Library Management System (LMS)

**A complete, console-based Library Management System (LMS) built purely in Kotlin, designed using a robust Layered Architecture.**

This project serves as a comprehensive example of structured programming and Object-Oriented Programming (OOP) in Kotlin, demonstrating how to manage core library operations, including member tracking, book inventory, loan processing, and reporting.

---

## ✨ Features

This **Kotlin Library Management System** includes essential functionalities spread across several architectural layers:

### Core System Management
*   **Layered Architecture:** Follows a clear structure separating Data, Repository (in-memory persistence), Services (business logic), UI (Console Menu), and Utils.
*   **Sample Data Initialization:** Initializes sample books and members automatically on startup.
*   **Console Interface:** Utilizes a `MenuSystem` for interactive user control, structured around a **main program loop** using `while` and `when` statements for navigation.

### Entity Management
*   **Books:** Tracks essential details like title, author, ISBN, price, genre (`BookGenre`), and availability status (`isAvailable`). Includes functions for checking in and checking out books.
*   **Members:** Members extend the `Person` class. They are assigned a `MembershipType` (e.g., BASIC, PREMIUM, STUDENT) which determines their `loanLimit`. Includes methods to manage borrowed books.
*   **Librarians:** Extends `Person` and includes administration methods like adding/removing books and approving memberships based on an `adminLevel`.
*   **Loans:** Tracks the relationship between books and members, including `loanDate`, `dueDate`, return status (`LoanStatus`), and fine calculation logic.

### Operations & Logic
*   **Validation:** Includes services for validating crucial data like ISBN format, email addresses, and prices.
*   **Searching:** Services are available for searching books by author, genre, or using advanced criteria (title, author, availability). Member searching is supported by name, email, or membership type.
*   **Fine Calculation:** Loans calculate fines based on overdue days, using a daily fine rate of `1.0`.
*   **Reporting:** Generates informative reports, including statistics on total books, available books, active members, membership distribution, and overdue loans.

---

## 🏗️ Architecture Overview

The codebase is organized into distinct packages reflecting its **Layered Architecture**:

| Layer | Responsibility | Key Components |
| :--- | :--- | :--- |
| **Data** | Core models and definitions (Entities/Enums). | `Book`, `Member`, `Loan`, `Person`, `BookGenre`. |
| **Repository** | In-memory data persistence (CRUD operations). | `BookRepository`, `MemberRepository`, `LoanRepository`. |
| **Services** | Business logic, coordination, and validation. | `LibraryService`, `LoanService`, `SearchService`, `ValidationService`. |
| **UI** | Console interaction and display logic. | `MenuSystem`, `Reports`, `ConsoleInput`. |
| **Utils** | Helper functions. | `DateUtils` (e.g., calculating days, adding days), `StringUtils` (e.g., capitalizing, formatting ISBN). |

---

## 🛠️ Technology Stack

*   **Language:** **Kotlin** (Compiled with Kotlin version 1.9.22 and language/API versions set to 1.9).
*   **Build Tool:** Gradle (using the Kotlin DSL: `build.gradle.kts` and `settings.gradle.kts`).
*   **JVM Target:** Java 17.
*   **Dependencies:** Uses standard Kotlin libraries and `org.jetbrains.kotlinx:kotlinx-datetime` for handling time-related operations.

---

## 🚀 Getting Started

The project uses Gradle for building and execution. The main entry point is defined in `com.library.LibraryApplication`.

### Prerequisites
You need a JVM environment capable of running Java 17.

### Build and Run Instructions

1.  Ensure all source files are placed in the correct directory structure.
2.  Navigate to the root directory of the project.
3.  Execute the following commands:

```bash
# Build the project
./gradlew clean build

# Run the application
./gradlew run
```

### Application Usage
Upon execution, the system will initialize sample data and display the **Welcome to Library Management System** message, followed by the current date. The console menu allows navigation to different areas of the system:

```
=== Welcome to Library Management System ===
Current Date: YYYY-MM-DD

=== Main Menu ===
1. Member Operations
2. Book Operations
3. Loan Operations
4. Reports
5. Exit
```

Choosing option `5` will terminate the program after displaying a thank you message.
