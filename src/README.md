## README.md

```markdown
# Library Management System

A comprehensive Kotlin project demonstrating core language features from basic syntax to advanced OOP concepts. This system manages books, members, loans, and library operations with a clean, modular architecture.

## 📖 Features

- **Core Library Operations**: Add/remove books, manage members, process loans
- **Search & Reports**: Advanced search by title/author/genre, generate statistics
- **Loan Management**: Borrowing, returns, overdue tracking, fine calculation
- **User Interface**: Console-based menu system with input validation
- **Data Persistence**: Repository pattern for data management
- **Error Handling**: Custom exceptions and validation services

## 🛠️ Tech Stack

- **Language**: Kotlin 1.9.22
- **Build Tool**: Gradle (Kotlin DSL)
- **Architecture**: Clean Architecture with Repository Pattern
- **Date Handling**: Java Time API + kotlinx-datetime
- **Testing**: Kotlin Test + JUnit Platform

## 📁 Project Structure

```
LibraryManagementSystem/
├── build.gradle.kts              # Build configuration
├── settings.gradle.kts           # Project settings
├── src/
│   ├── main/kotlin/com/library/  # Source code
│   │   ├── data/                 # Entity classes & enums
│   │   ├── services/             # Business logic
│   │   ├── repository/           # Data access layer
│   │   ├── ui/                   # User interface
│   │   ├── utils/                # Utility functions
│   │   └── exceptions/           # Custom exceptions
│   └── test/kotlin/com/library/  # Unit tests
└── gradle/                       # Gradle wrapper
```

## 🚀 Quick Start

### Prerequisites
- Java 17+ JDK
- Gradle 8.0+ (or use Gradle wrapper)

### Setup & Run

1. **Clone/Download** the project
2. **Build** the project:
   ```bash
   ./gradlew clean build
   ```
3. **Run** the application:
   ```bash
   ./gradlew run
   ```
4. **Run tests**:
   ```bash
   ./gradlew test
   ```

### IDE Setup
- **IntelliJ IDEA**: Open as Gradle project, auto-import
- **VS Code**: Install Kotlin extension, open folder
- **Eclipse**: Import as Gradle project

## 🎯 Kotlin Concepts Demonstrated

### Basic Syntax
- Variables (`var`/`val`), data types, operators
- String interpolation, null safety
- Collections (Lists, filtering, mapping)

### Control Flow
- `if-else` expressions, `when` expressions
- `while` loops, `for` loops, `break`/`continue`
- Kotlin ranges (`1..10`, `in` operator)

### Functions
- Function declarations, default parameters
- Higher-order functions, lambdas
- Extension functions, inline functions

### OOP Features
- Classes, objects, constructors (primary/secondary)
- Inheritance, abstract classes
- Properties (getters/setters), companion objects
- Encapsulation, visibility modifiers

### Advanced
- Enums with properties and methods
- Data classes, sealed classes
- Exception handling, custom exceptions
- Generics, type inference

## 🏗️ Architecture Overview

### Layers
1. **Presentation (UI)**: `MenuSystem`, `ConsoleInput`, `Reports`
2. **Business Logic (Services)**: `LibraryService`, `LoanService`, `SearchService`
3. **Data Access (Repositories)**: `BookRepository`, `MemberRepository`, `LoanRepository`
4. **Domain Models**: `Book`, `Member`, `Loan`, enums
5. **Utilities**: Date handling, string manipulation, validation
6. **Cross-cutting**: Custom exceptions, constants

### Key Design Patterns
- **Repository Pattern**: Data abstraction and persistence
- **Dependency Injection**: Service composition
- **Single Responsibility**: Each class has one purpose
- **SOLID Principles**: Implemented throughout

## 📋 Usage Examples

### Main Menu
```
=== Welcome to Library Management System ===
1. Member Operations
2. Book Operations  
3. Loan Operations
4. Reports
5. Exit
```

### Sample Operations
- **Add Book**: Title, author, ISBN, price, genre
- **Search**: By title, author, genre (case-insensitive)
- **Borrow/Return**: Validate eligibility, update status
- **Reports**: Book availability, member statistics, overdue loans

## 🧪 Testing

Unit tests demonstrate:
```kotlin
// Example test structure
@Test
fun `should calculate overdue fine correctly`() {
    // Given
    val loan = Loan(...)
    // When
    val fine = fineCalculator.calculateFine(loan)
    // Then
    assertEquals(expected, fine)
}
```

Run tests with:
```bash
./gradlew test
```

## 🔧 Configuration

### build.gradle.kts
- Kotlin 1.9.22 (stable)
- Java 17 target
- JSR-305 strict mode

### Resources
- `application.properties`: App configuration
- `sample-data/`: CSV files for initialization
- `logback.xml`: Logging configuration

## 🐛 Troubleshooting

### Common Issues
1. **Kotlin Version**: Ensure stable 1.9.x, not experimental
2. **Java Version**: Requires Java 17+
3. **Gradle Sync**: Refresh/reimport Gradle project
4. **Package Structure**: Verify `src/main/kotlin/com/library/...`

### Build Commands
```bash
./gradlew clean          # Clean build artifacts
./gradlew build          # Full build
./gradlew run            # Run application
./gradlew test           # Run tests
./gradlew dependencies   # Show dependency tree
```

## 📈 Extending the Project

### Add Features
1. **Database Integration**: Replace repositories with JPA/Hibernate
2. **Web Interface**: Add Ktor/Spring Boot REST API
3. **GUI**: JavaFX or Compose Desktop
4. **File Persistence**: JSON/CSV export/import
5. **Notifications**: Email/SMS for overdue reminders

### Customization
- Modify `MembershipType` enum for new tiers
- Add custom `BookGenre` values
- Extend `Loan` with reservation functionality
- Implement advanced search with full-text indexing

## 📄 License

This project is educational and provided under MIT License. See [LICENSE](LICENSE) for details.

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open Pull Request

## 🙌 Acknowledgments

Built to demonstrate Kotlin best practices and language features. Perfect for learning OOP, functional programming, and clean architecture in Kotlin.

---

**Happy Coding!** 📚✨
```

## Additional Files to Create in Root:

### settings.gradle.kts
```kotlin
rootProject.name = "LibraryManagementSystem"
include("app")
```

### .gitignore
```gitignore
# Gradle
.gradle/
build/
!gradle/wrapper/gradle-wrapper.jar

# IDE
.idea/
*.iml
.vscode/
*.swp
*.swo

# OS
.DS_Store
Thumbs.db

# Logs
*.log
logs/

# Dependencies
*.jar
lib/
```

### gradle.properties
```properties
kotlin.code.style=official
kotlin.jvm.target.validation.mode=warning
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
kotlin.incremental=true
```

Save the `README.md` in the **root directory** alongside `build.gradle.kts`. This provides comprehensive documentation for setup, usage, and extension of the Library Management System project.

```
LibraryManagementSystem/
│
├── build.gradle.kts                    # Project build configuration
├── settings.gradle.kts                 # Project settings
├── gradle.properties                   # Gradle properties
│
├── src/
│   └── main/
│       ├── kotlin/
│           └── com/
│               └── library/
│                   │
│                   ├── LibraryApplication.kt          # Main entry point
│                   │
│                   ├── data/                          # Data models and entities
│                   │   ├── Book.kt
│                   │   ├── Member.kt
│                   │   ├── Librarian.kt
│                   │   ├── Loan.kt
│                   │   ├── Person.kt                  # Base class for inheritance
│                   │   └── enums/
│                   │       ├── BookGenre.kt
│                   │       ├── MembershipType.kt
│                   │       └── LoanStatus.kt
│                   │
│                   ├── services/                       # Business logic and utilities
│                   │   ├── LibraryService.kt
│                   │   ├── LoanService.kt
│                   │   ├── FineCalculator.kt
│                   │   ├── SearchService.kt
│                   │   └── ValidationService.kt
│                   │
│                   ├── repository/                     # Data access layer
│                   │   ├── BookRepository.kt
│                   │   ├── MemberRepository.kt
│                   │   └── LoanRepository.kt
│                   │
│                   ├── ui/                             # User interface components
│                   │   ├── MenuSystem.kt
│                   │   ├── ConsoleInput.kt
│                   │   └── Reports.kt
│                   │
│                   ├── utils/                          # Utility functions and helpers
│                   │   ├── DateUtils.kt
│                   │   ├── StringUtils.kt
│                   │   └── Constants.kt
│                   │
│                   └── exceptions/                     # Custom exceptions
│                       ├── BookNotFoundException.kt
│                       ├── MemberNotEligibleException.kt
│                       └── OverdueException.kt
│
│   └── resources/
│       ├── application.properties                      # Configuration
│       ├── sample-data/                               # Initial data files
│       │   ├── books.csv
│       │   └── members.csv
│       └── logback.xml                                # Logging configuration
│
├── src/
│   └── test/
│       └── kotlin/
│           └── com/
│               └── library/
│                   ├── data/
│                   │   ├── BookTest.kt
│                   │   ├── MemberTest.kt
│                   │   └── LoanTest.kt
│                   ├── services/
│                   │   ├── LibraryServiceTest.kt
│                   │   ├── LoanServiceTest.kt
│                   │   └── FineCalculatorTest.kt
│                   └── utils/
│                       └── DateUtilsTest.kt
│
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
│
├── .gitignore
├── README.md
└── runConfigurations/
    └── LibraryApplication.xml                         # IDE run configuration
```