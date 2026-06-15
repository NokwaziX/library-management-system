package com.nokwazi.library;

import com.nokwazi.library.model.*;
import com.nokwazi.library.service.LibraryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {
    private LibraryManager   library;
    private RegularBorrower  regular;
    private PremiumBorrower  premium;
    private StudentBorrower  student;
    private Librarian        librarian;
    private LibraryAssistant assistant;

    @BeforeEach
    void setUp() {
        library   = new LibraryManager("WeThinkCode Library");
        regular   = new RegularBorrower("Alice", "Dlamini", "alice@email.com",  "071 000 0001", "B001");
        premium   = new PremiumBorrower("Bob",   "Nkosi",   "bob@email.com",    "071 000 0002", "B002");
        student   = new StudentBorrower("Carol", "Botha",   "carol@email.com",  "071 000 0003", "B003", "STU12345");
        librarian = new Librarian("Dave", "Sithole", "dave@library.com", "071 000 0004", "E001", 4, "Archives", "BLIS Degree");
        assistant = new LibraryAssistant("Eve", "Khumalo", "eve@library.com",  "071 000 0005", "E002", 2, "Fiction");
    }

    @Test
    void libraryNameReturnsCorrectName() {
        assertEquals("WeThinkCode Library", library.libraryName());
    }

    @Test
    void addBorrowerIncreasesCount() {
        library.addBorrower(regular);
        assertEquals(1, library.borrowers().size());
    }

    @Test
    void borrowersReturnsUnmodifiableView() {
        library.addBorrower(regular);
        assertThrows(UnsupportedOperationException.class,
                () -> library.borrowers().add(premium));
    }

    @Test
    void findBorrowerReturnsCorrectBorrower() {
        library.addBorrower(regular);
        library.addBorrower(premium);
        Borrower found = library.findBorrower("B001");
        assertNotNull(found);
        assertEquals("Alice", found.firstName());
    }

    @Test
    void findBorrowerReturnsNullForUnknownId() {
        assertNull(library.findBorrower("UNKNOWN"));
    }

    @Test
    void removeBorrowerDecreasesCount() {
        library.addBorrower(regular);
        library.addBorrower(premium);
        library.removeBorrower("B001");
        assertEquals(1, library.borrowers().size());
    }

    @Test
    void removeBorrowerThrowsForUnknownId() {
        assertThrows(IllegalArgumentException.class,
                () -> library.removeBorrower("UNKNOWN"));
    }

    @Test
    void activeBorrowersReturnsOnlyActive() {
        library.addBorrower(regular);
        library.addBorrower(premium);
        premium.makeActive(false);
        assertEquals(1, library.activeBorrowers().size());
        assertEquals("B001", library.activeBorrowers().get(0).borrowerId());
    }

    @Test
    void activeBorrowersReturnsAllWhenAllActive() {
        library.addBorrower(regular);
        library.addBorrower(premium);
        library.addBorrower(student);
        assertEquals(3, library.activeBorrowers().size());
    }

    @Test
    void addStaffIncreasesCount() {
        library.addStaff(librarian);
        assertEquals(1, library.staffList().size());
    }

    @Test
    void staffListReturnsUnmodifiableView() {
        library.addStaff(librarian);
        assertThrows(UnsupportedOperationException.class,
                () -> library.staffList().add(assistant));
    }

    @Test
    void findStaffReturnsCorrectStaff() {
        library.addStaff(librarian);
        library.addStaff(assistant);
        Staff found = library.findStaff("E002");
        assertNotNull(found);
        assertEquals("Eve", found.firstName());
    }

    @Test
    void findStaffReturnsNullForUnknownId() {
        assertNull(library.findStaff("UNKNOWN"));
    }

    @Test
    void totalMonthlyStaffCostSumsAllSalaries() {
        library.addStaff(librarian);
        library.addStaff(assistant);
        double expected = librarian.monthlySalary() + assistant.monthlySalary();
        assertEquals(expected, library.totalMonthlyStaffCost(), 0.001);
    }

    @Test
    void totalMonthlyStaffCostIsZeroWithNoStaff() {
        assertEquals(0.0, library.totalMonthlyStaffCost(), 0.001);
    }

    @Test
    void printAllRolesDoesNotThrow() {
        library.addBorrower(regular);
        library.addStaff(librarian);
        assertDoesNotThrow(() -> library.printAllRoles());
    }
}
