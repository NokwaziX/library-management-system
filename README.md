# 📚 Library Management System — Java OOP Assessment

## Overview
In this assessment you will design and implement a library management system in Java. The system manages two distinct branches of people — **Borrowers** and **Staff** — through a shared class hierarchy rooted at `Person`.

Your task is to implement all classes described below, demonstrating the four core OOP principles:

| Principle | Where you'll apply it |
|---|---|
| Encapsulation | Private fields, controlled getters/setters, immutable fields |
| Inheritance | Two-level hierarchy: `Person → Borrower/Staff → concrete types` |
| Polymorphism | `role()`, `borrowingLimit()`, `monthlySalary()` behave differently per type |
| Abstraction | `Person`, `Borrower`, and `Staff` are abstract — concrete types must fulfil the contract |

---

## Assessment Structure

| Component | Weight | Recommended Time |
|---|---|---|
| Implementation | 50% | 2 hours |
| Comprehensive Long Question | 50% | 1 hour |

---

## Class Hierarchy

```
Person  (abstract)
├── Borrower  (abstract)
│   ├── RegularBorrower
│   ├── PremiumBorrower
│   └── StudentBorrower
└── Staff  (abstract)
    ├── Librarian
    └── LibraryAssistant
```

---

## Project Structure

```
we-library/
  pom.xml
  src/
    main/java/za/co/wethinkcode/
      Main.java
      model/
        Person.java
        Borrower.java
        RegularBorrower.java
        PremiumBorrower.java
        StudentBorrower.java
        Staff.java
        Librarian.java
        LibraryAssistant.java
      service/
        LibraryManager.java
    test/java/za/co/wethinkcode/
      PersonTest.java
      BorrowerTest.java
      StaffTest.java
      LibraryManagerTest.java
```

> Do **NOT** modify any test files or `Main.java`. All your work goes in `model` and `service`.

---

## Implementation Steps

### Step 1 — Implement `Person` (Abstract)
**File:** `src/main/java/za/co/wethinkcode/model/Person.java`

`Person` is the root of the entire hierarchy.

#### Fields
| Field | Type | Details |
|---|---|---|
| `firstName` | String | Private and immutable |
| `lastName` | String | Private and immutable |
| `email` | String | Private |
| `phoneNumber` | String | Private |

#### Constructor
Accepts `firstName`, `lastName`, `email`, `phoneNumber`.

#### Methods
| Method | Details |
|---|---|
| `firstName()` | Returns first name |
| `lastName()` | Returns last name |
| `email()` / `addEmail(String)` | Getter and setter |
| `phoneNumber()` / `addPhoneNumber(String)` | Getter and setter |
| `fullName()` | Returns `firstName + " " + lastName` |
| `toString()` | Returns a summary including full name and email |
| `role()` | Abstract. Every subclass must provide its own role description |

---

### Step 2 — Implement `Borrower` (Abstract)
**File:** `src/main/java/za/co/wethinkcode/model/Borrower.java`

`Borrower` extends `Person` and adds borrowing-specific state.

#### Additional Fields
| Field | Type | Details |
|---|---|---|
| `borrowerId` | String | Private and immutable |
| `active` | boolean | Private; defaults to `true` |

#### Constructor
Accepts `firstName`, `lastName`, `email`, `phoneNumber`, `borrowerId`. Calls `super()`. Sets `active` to `true`.

#### Methods
| Method | Details |
|---|---|
| `borrowerId()` | Returns borrower ID. No setter |
| `isActive()` / `makeActive(boolean)` | Getter and setter |
| `toString()` | Extends parent summary with `borrowerId` and active status |
| `borrowingLimit()` | Abstract. Returns the max number of books this borrower may have out at once |
| `loanPeriodDays()` | Abstract. Returns the number of days a borrower may keep a book |

---

### Step 3 — Implement `RegularBorrower`, `PremiumBorrower`, `StudentBorrower`

All three extend `Borrower` and implement every abstract method. Use `@Override` on every overridden method.

#### RegularBorrower
| Detail | Value |
|---|---|
| Extends | `Borrower` |
| Extra fields | None |
| `MAX_BOOKS` | `public static final int MAX_BOOKS = 3` |
| `borrowingLimit()` | Returns `MAX_BOOKS` |
| `loanPeriodDays()` | Returns `14` |
| `role()` | Returns `"Regular Borrower"` |
| `toString()` | Includes `"Regular Borrower"` and parent summary |

#### PremiumBorrower
| Detail | Value |
|---|---|
| Extends | `Borrower` |
| Extra field | `reservationsAllowed` (boolean) — private, defaults to `true`. Getter and setter |
| `MAX_BOOKS` | `public static final int MAX_BOOKS = 10` |
| `borrowingLimit()` | Returns `MAX_BOOKS` |
| `loanPeriodDays()` | Returns `30` |
| `role()` | Returns `"Premium Borrower"` |
| `toString()` | Includes `"Premium Borrower"` and whether reservations are allowed |

#### StudentBorrower
| Detail | Value |
|---|---|
| Extends | `Borrower` |
| Extra field | `studentNumber` (String) — private and immutable. Getter only, no setter |
| Constructor | Accepts all `Borrower` params plus `studentNumber` |
| `MAX_BOOKS` | `public static final int MAX_BOOKS = 5` |
| `borrowingLimit()` | Returns `MAX_BOOKS` |
| `loanPeriodDays()` | Returns `21` |
| `role()` | Returns `"Student Borrower"` |
| `toString()` | Includes `"Student Borrower"` and the student number |

---

### Step 4 — Implement `Staff` (Abstract)
**File:** `src/main/java/za/co/wethinkcode/model/Staff.java`

#### Additional Fields
| Field | Type | Details |
|---|---|---|
| `employeeId` | String | Private and immutable |
| `yearsOfService` | int | Private |

#### Constructor
Accepts `firstName`, `lastName`, `email`, `phoneNumber`, `employeeId`, `yearsOfService`. Calls `super()`.

#### Methods
| Method | Details |
|---|---|
| `employeeId()` | Returns employee ID. No setter |
| `yearsOfService()` / `updateYearsOfService(int)` | Getter and setter. Setter throws `IllegalArgumentException` if value is negative |
| `toString()` | Extends parent summary with `employeeId` and `yearsOfService` |
| `monthlySalary()` | Abstract |
| `duties()` | Abstract |

---

### Step 5 — Implement `Librarian` and `LibraryAssistant`

#### Librarian
| Detail | Value |
|---|---|
| Extends | `Staff` |
| Extra fields | `specialisation` (String) — mutable. `qualification` (String) — immutable |
| `BASE_SALARY` | `public static final double BASE_SALARY = 22_000.00` |
| `SALARY_PER_YEAR` | `public static final double SALARY_PER_YEAR = 600.00` |
| `monthlySalary()` | Returns `BASE_SALARY + (yearsOfService × SALARY_PER_YEAR)` |
| `duties()` | Returns `"Cataloguing, reference assistance, and collection management"` |
| `role()` | Returns `"Librarian (" + specialisation + ")"` |
| `toString()` | Includes `specialisation` and `qualification` |

#### LibraryAssistant
| Detail | Value |
|---|---|
| Extends | `Staff` |
| Extra field | `section` (String) — mutable |
| `MONTHLY_SALARY` | `public static final double MONTHLY_SALARY = 10_000.00` |
| `monthlySalary()` | Returns `MONTHLY_SALARY` — fixed |
| `duties()` | Returns `"Shelving books, member check-in, and issue desk"` |
| `role()` | Returns `"Library Assistant (" + section + " section)"` |
| `toString()` | Includes section information |

---

### Step 6 — Implement `LibraryManager`
**File:** `src/main/java/za/co/wethinkcode/service/LibraryManager.java`

#### Fields
| Field | Type | Details |
|---|---|---|
| `libraryName` | String | Private and immutable |
| `borrowers` | `List<Borrower>` | Private |
| `staffList` | `List<Staff>` | Private |

#### Constructor
Accepts `libraryName`. Initialises both lists as empty `ArrayList`s.

#### Methods
| Method | Details |
|---|---|
| `addBorrower(Borrower)` | Adds a borrower |
| `removeBorrower(String borrowerId)` | Removes by ID. Throws `IllegalArgumentException` if not found |
| `findBorrower(String borrowerId)` | Returns the `Borrower` or `null` if not found |
| `borrowers()` | Returns `Collections.unmodifiableList(borrowers)` |
| `activeBorrowers()` | Returns a new list of borrowers where `isActive()` is `true` |
| `addStaff(Staff)` | Adds a staff member |
| `findStaff(String employeeId)` | Returns the `Staff` or `null` if not found |
| `staffList()` | Returns `Collections.unmodifiableList(staffList)` |
| `totalMonthlyStaffCost()` | Sums `monthlySalary()` for all staff. Returns `0.0` if none |
| `printAllRoles()` | Calls `role()` on every `Person` and prints each to `System.out` |
| `libraryName()` | Returns the library name |

---

## Comprehension Questions

Answer all five questions in the `answers.txt` file. Write in full sentences.

**Question 1 — Object-Oriented Programming (10 marks)**
Your team lead is reviewing your code and asks you to walk them through the four core OOP principles — Encapsulation, Abstraction, Inheritance, and Polymorphism. For each principle, explain what it is, how you would identify it when reading through a codebase, and what it is used for.

**Question 2 — Problem Statements (10 marks)**
You have just joined a development team and been handed a vague brief for a new feature. A senior developer tells you to write a problem statement before writing a single line of code. Explain what a problem statement is, what it should contain, and why it is important to define it clearly before development begins.

**Question 3 — Test-Driven Development (10 marks)**
A junior developer on your team has never heard of TDD and asks you to explain it. Describe the process and the cycle that governs it, what happens at each stage, why tests are written before the implementation, and what effect this has on the quality and design of the code produced.

**Question 4 — The Super Constructor (10 marks)**
A classmate is getting a compilation error they cannot explain — their subclass constructor is failing and they do not understand why. Explain what the super constructor is, why it exists, and how it is used. Use a short code example to support your explanation.

**Question 5 — Technical Reflection (10 marks)**
Reflect on a project you have worked on during this programme. Describe it from a technical perspective, addressing the architecture, how OOP principles were applied, how components communicated, and how correctness was ensured through testing.

---

Keep the pages turning! 📖