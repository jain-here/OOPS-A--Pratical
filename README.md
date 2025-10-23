# OOPS-A--Practical

This repository contains comprehensive Java programs for the Object-Oriented Programming lab, covering fundamental concepts and advanced scenario-based implementations.

## 📚 Contents

### 1. Concept-based Programs

This directory contains programs that demonstrate fundamental concepts of Java.

*   **Question1.java**: Prints the size of various data types
*   **Question2.java**: Takes student details as input and displays them
*   **Question3.java**: Demonstrates widening type conversion and type casting
*   **Question4.java**: Demonstrates narrowing type casting
*   **Question5.java**: Converts a character to its ASCII value
*   **Question6.java**: Demonstrates operator precedence
*   **Question7.java**: Calculates the average of three numbers
*   **Question8.java**: Performs basic arithmetic operations
*   **Question9.java**: Demonstrates bitwise operators
*   **Question10.java**: Checks if a number is divisible by 3 and 5
*   **Question11.java**: Calculates the area and circumference of a circle
*   **Question12.java**: Demonstrates the use of the `final` keyword
*   **Question13.java**: Finds the greatest of three numbers

### 2. Scenario-based Programs

This directory contains advanced scenario-based programs organized by topic.

---

## 🔍 Reflection API and Annotations

Demonstrates runtime introspection, custom annotations, and metadata programming.

### Q1: Product Reflection
- **Files**: `Product.java`, `ProductReflectionReader.java`
- **Concept**: Basic reflection to load class, instantiate objects, and invoke methods dynamically
- **Features**: Class loading, object instantiation, method invocation using Reflection API

### Q2: API Documentation
- **Files**: `APIDescription.java`, `AuthenticationService.java`, `APIDocumentationReader.java`
- **Concept**: Custom annotations for embedded API documentation
- **Features**: @APIDescription annotation, reflection-based documentation extraction

### Q3: Cloud Service Documentation
- **Files**: `APIInfo.java`, `UserAPI.java`, `CloudServiceDocGenerator.java`
- **Concept**: Auto-generate API documentation from annotated code
- **Features**: @APIInfo annotation with endpoint and HTTP method, documentation generation

### Q4: Runtime Inspection
- **Files**: `DebugSampleClass.java`, `RuntimeClassInspector.java`
- **Concept**: Runtime class inspection for debugging and logging
- **Features**: Field inspection, method discovery, constructor analysis

### Q5: Custom Validation
- **Files**: `NotEmpty.java`, `Customer.java`, `ValidationUtility.java`
- **Concept**: Reflection-based field validation framework
- **Features**: @NotEmpty annotation, automatic validation, constraint checking

### Q6: Role-Based Access Control
- **Files**: `RoleAllowed.java`, `UserService.java`, `RoleBasedAccessControl.java`
- **Concept**: Method-level security using annotations
- **Features**: @RoleAllowed annotation, access control simulation

### Q7: Logging Metadata
- **Files**: `Loggable.java`, `AccountService.java`, `AuditLogger.java`
- **Concept**: Automatic audit logging for banking transactions
- **Features**: @Loggable annotation, method execution logging

### Q8: Version Tracking
- **Files**: `Version.java`, `ReportGenerator.java`, `VersionTracker.java`
- **Concept**: Embed and retrieve version information
- **Features**: @Version annotation, version metadata extraction

### Q9: Unit Testing Framework
- **Files**: `TestCase.java`, `CalculatorTest.java`, `TestRunner.java`
- **Concept**: Mini testing framework using reflection
- **Features**: @TestCase annotation, automatic test discovery and execution

---

## 📋 ArrayList Programs

Demonstrates ArrayList operations for real-world scenarios.

### Q1: Student Name Manager
- **File**: `StudentNameManager.java`
- **Operations**: add(), add(index, element), remove(), contains(), size()
- **Use Case**: Managing student roster with add, remove, and search capabilities

### Q2: Product Inventory Manager
- **File**: `ProductInventoryManager.java`
- **Operations**: set(), add(), clear(), for-each loop, sum calculation
- **Use Case**: Tracking product quantities, updating stock, calculating totals

### Q3: To-Do List Manager
- **File**: `ToDoListManager.java`
- **Operations**: add(), remove(), get(), isEmpty(), Collections.sort()
- **Use Case**: Task management with add, complete, sort, and search features

---

## 🎯 Generics Programs

Demonstrates type-safe generic classes and methods.

### Q1: Generic Box Utility
- **File**: `GenericBoxDemo.java`
- **Concept**: Generic class Box<T> with type-safe operations
- **Features**: set(), get(), compareBoxes() generic method

### Q2: Banking Account System
- **Concept**: Generic class for different numeric balance types
- **Use Case**: Storing Integer, Double, BigDecimal balances

### Q3: Hospital Patient Records
- **Concept**: Generic PatientRecord<T> for different ID types
- **Use Case**: Managing patient data with Integer, String, UUID IDs

---

## 🔢 Bounded Types in Generics

### Q1: Scientific Computation
- **Concept**: calculateSum(List<? extends Number> list)
- **Features**: Sum calculation for Integer, Float, Double

### Q2: Data Analytics
- **Concept**: Calculate average from numeric sensor data
- **Features**: Bounded type parameters for flexibility

### Q3: Banking Analytics
- **Concept**: Average transaction amount calculation
- **Features**: <T extends Number> for arithmetic operations

---

## 🔄 Comparator and Comparable

### Q1: Employee Sorting
- **Concept**: Sort employees by salary
- **Implementations**: Comparable (natural ordering), Comparator (custom ordering)

### Q2: Music Streaming Platform
- **Concept**: Sort songs by title and duration
- **Features**: Comparable and Comparator demonstrations

### Q3: Sports Analytics
- **Concept**: Sort athletes by name and score
- **Features**: When to use Comparable vs Comparator

---

## 🎨 Lambda Expressions and Sorting

### Q1: E-commerce Product Sorting
- **Concept**: Sort by rating (desc) then price (asc) using lambdas
- **Features**: Multi-criteria sorting with lambda expressions

### Q2: Ride-Sharing Application
- **Concept**: Sort drivers by rating and distance
- **Features**: Lambda-based custom sorting

### Q3: Online Shopping
- **Concept**: Sort by highest rating then lowest price
- **Features**: Simplified sorting with lambdas

---

## ⚡ Functional Interfaces

### Predicate and Consumer

### Q1: School Management System
- **Interfaces**: Predicate<Student> (filter by grade), Consumer<Student> (display)
- **Use Case**: Filter students scoring above 75%

### Q2: Product Management
- **Interfaces**: Predicate (filter by price), Consumer (print details)
- **Use Case**: Display products under ₹1000

### Q3: Fitness Tracking
- **Interfaces**: Predicate (filter by steps), Consumer (display users)
- **Use Case**: Users with > 10,000 steps

---

## 🌊 Stream API Programs

### map() and filter()

### Q1: Employee Salary Processing
- **Operations**: filter (salary > 30k), map (increase by 10%)
- **Features**: Data transformation pipeline

### Q2: Weather Station
- **Operations**: filter (temp > 30°C), map (Celsius to Fahrenheit)
- **Features**: Temperature conversion and filtering

### Q3: Online Learning Platform
- **Operations**: filter (score > 60%), map (convert to grades)
- **Features**: Score to grade conversion

### reduce()

### Q1: Sales Calculation
- **Operation**: reduce() to calculate total sales
- **Features**: Aggregate operations

### Q2: Personal Finance
- **Operation**: reduce() for total expenditure
- **Features**: Monthly expense summation

### Q3: Travel Agency
- **Operation**: reduce() for total distance
- **Features**: Distance aggregation

### collect() and groupingBy()

### Q1: University Result System
- **Operations**: groupingBy(department), averagingInt(marks)
- **Features**: Group students and calculate averages

### Q2: Employee Department Grouping
- **Operations**: groupingBy(department), counting()
- **Features**: Group and count employees

---

## 🎬 Combined Full Application Scenarios

### Q1: Library Management System
- **Features**: Filter (rating > 4), sort (by price), collect (titles)
- **Technologies**: Stream API, Lambda, Comparator

### Q2: Movie Recommendation System
- **Features**: Filter (rating > 4.0), sort (by year), collect (titles)
- **Technologies**: Complete stream pipeline

---

## ⚠️ Exception Handling Programs

### Q1: Banking Application
- **File**: `BankingApplication.java`
- **Exceptions**: NullPointerException, ArithmeticException
- **Features**: Nested try-catch-finally blocks

### Q2: HR Application with Serialization
- **Exceptions**: IOException, NotSerializableException
- **Features**: Transient keyword, sensitive data handling

### Q3: Flight Check-In System
- **Exception**: Custom LateCheckInException
- **Features**: Custom exception handling

### Q4: Patient Report Processing
- **Exceptions**: IOException, FileNotFoundException
- **Features**: BufferedReader file operations

### Q5: Travel Booking System
- **Exception**: Custom InvalidDestinationException
- **Features**: Input validation

### Q6: School System File Backup
- **Exceptions**: IOException
- **Features**: Try-with-resources, file operations

### Q7: Voter Registration
- **Exception**: Custom InvalidAgeException
- **Features**: Age validation

### Q8: Online Shopping System
- **Exceptions**: IllegalArgumentException, NullPointerException
- **Features**: Order processing with exception handling

### Q9: Library Management
- **Exception**: Custom BookNotAvailableException
- **Features**: Book loan processing

### Q10: Payroll System
- **Exceptions**: IOException, FileNotFoundException
- **Features**: Hours calculation from file

---

## 💾 Serialization Programs (Q11-Q16)

### Q11: Student Serialization
- **Features**: Serializable, transient keyword, list serialization

### Q12: Employee Serialization
- **Features**: ObjectOutputStream, try-with-resources

### Q13: Product Serialization
- **Features**: E-commerce inventory serialization

### Q14: Course Serialization
- **Features**: Serialize and deserialize course data

### Q15: Vehicle Serialization
- **Features**: Rental system vehicle data

### Q16: Ticket Serialization
- **Features**: Event management ticket system

---

## 📁 File I/O Programs (Q17-Q21)

### Q17: Banking Transaction Log
- **Operations**: FileWriter, append mode
- **Features**: Transaction logging

### Q18: Patient Records Reader
- **Operations**: FileReader, BufferedReader
- **Features**: Patient data processing

### Q19: Library Books Filter
- **Operations**: Read and filter book data
- **Features**: Create filtered output file

### Q20: Restaurant Orders Log
- **Operations**: FileWriter append
- **Features**: Order details logging

### Q21: Weather Monitoring
- **Operations**: BufferedReader, temperature filtering
- **Features**: City weather data processing

---

## 🧬 Advanced Generics and Functional Programming (Q22-Q33)

### Q22-Q26: Generic Classes
- Team<T>, Cart<T>, Pair<K,V>
- Consumer and Predicate with lambdas
- Generic collections

### Q27-Q33: Stream and Functional Programming
- Employee filtering, task management
- Movie reviews, fitness tracking
- Comprehensive functional style programming

---

## 🔢 Sorting and Stream API (Q34-Q39)

### Q34-Q36: Custom Comparators
- Medicine inventory, Book sorting
- Pharmacy management

### Q37-Q39: Stream Processing
- Song filtering, Event management
- Music streaming platform

---

## 🏛️ Legacy Programs

### Abstract Class
*   **FoodDeliveryApp.java**: Food delivery system using abstract classes

### Exception Handling
*   **DivideByZero.java**: Simple ArithmeticException handling

### Inheritance
*   **Inheritance_Concept_based_programs.java**: Single and multilevel inheritance demos

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Running Programs

```bash
# Compile
javac ProgramName.java

# Run
java ProgramName
```

### For Reflection API Programs
```bash
# Compile all files in directory
javac *.java

# Run the main reader/runner class
java ReflectionReader
```

---

## 📖 Learning Outcomes

After completing these programs, you will understand:

✅ Reflection API and runtime introspection  
✅ Custom annotations and metadata programming  
✅ ArrayList operations and collections  
✅ Generic programming and type safety  
✅ Bounded type parameters  
✅ Comparator and Comparable interfaces  
✅ Lambda expressions and functional programming  
✅ Stream API operations  
✅ Exception handling best practices  
✅ File I/O operations  
✅ Serialization and deserialization  

---

## 📝 Program Structure

Each scenario-based program follows this structure:
```
CategoryName/
├── QuestionNumber_ProgramName/
│   ├── Annotation.java (if applicable)
│   ├── MainClass.java
│   └── ReaderOrRunner.java (if applicable)
```

---

## 👨‍💻 Author

**Repository**: OOPS-A--Practical  
**Course**: Object-Oriented Programming  
**Focus**: Java Programming Fundamentals to Advanced Concepts

---

## 📄 License

This project is for educational purposes.

---

## 🤝 Contributing

Feel free to fork this repository and add more programs or improvements!

---

**Note**: This repository demonstrates comprehensive Java programming concepts from basics to advanced topics including reflection, generics, functional programming, and modern Java features.
