package com.nokwazi.library;

import com.nokwazi.library.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BorrowerTest {
    private RegularBorrower regular;
    private PremiumBorrower premium;
    private StudentBorrower student;

    @BeforeEach
    void setUp() {
        regular = new RegularBorrower("Alice", "Dlamini", "alice@email.com", "071 000 0001", "B001");
        premium = new PremiumBorrower("Bob",   "Nkosi",   "bob@email.com",   "071 000 0002", "B002");
        student = new StudentBorrower("Carol", "Botha",   "carol@email.com", "071 000 0003", "B003", "STU12345");
    }

    @Test
    void borrowerDefaultsActiveToTrue() {
        assertTrue(regular.isActive(), "RegularBorrower should default to active");
        assertTrue(premium.isActive(), "PremiumBorrower should default to active");
        assertTrue(student.isActive(), "StudentBorrower should default to active");
    }

    @Test
    void makeActiveUpdatesValue() {
        regular.makeActive(false);
        assertFalse(regular.isActive());
        regular.makeActive(true);
        assertTrue(regular.isActive());
    }

    @Test
    void borrowerIdReturnsCorrectId() {
        assertEquals("B001", regular.borrowerId());
        assertEquals("B002", premium.borrowerId());
        assertEquals("B003", student.borrowerId());
    }

    @Test
    void borrowerIsSubclassOfPerson() {
        assertInstanceOf(Person.class, regular);
        assertInstanceOf(Person.class, premium);
        assertInstanceOf(Person.class, student);
    }

    @Test
    void regularBorrowerLimitCorrect() {
        assertEquals(RegularBorrower.MAX_BOOKS, regular.borrowingLimit());
    }

    @Test
    void regularBorrowerLoanPeriodCorrect() {
        assertEquals(14, regular.loanPeriodDays());
    }

    @Test
    void regularBorrowerRoleCorrect() {
        assertEquals("Regular Borrower", regular.role());
    }

    @Test
    void regularBorrowerToStringContainsRole() {
        assertTrue(regular.toString().contains("Regular Borrower"),
                "RegularBorrower toString() should mention the role");
    }

    @Test
    void premiumBorrowerLimitCorrect() {
        assertEquals(PremiumBorrower.MAX_BOOKS, premium.borrowingLimit());
    }

    @Test
    void premiumBorrowerLoanPeriodCorrect() {
        assertEquals(30, premium.loanPeriodDays());
    }

    @Test
    void premiumBorrowerRoleCorrect() {
        assertEquals("Premium Borrower", premium.role());
    }

    @Test
    void premiumBorrowerDefaultsReservationsAllowedTrue() {
        assertTrue(premium.isReservationsAllowed(),
                "reservationsAllowed should default to true");
    }

    @Test
    void premiumBorrowerSetReservationsUpdatesValue() {
        premium.setReservationsAllowed(false);
        assertFalse(premium.isReservationsAllowed());
    }

    @Test
    void premiumBorrowerToStringContainsRole() {
        assertTrue(premium.toString().contains("Premium Borrower"),
                "PremiumBorrower toString() should mention the role");
    }

    @Test
    void studentBorrowerLimitCorrect() {
        assertEquals(StudentBorrower.MAX_BOOKS, student.borrowingLimit());
    }

    @Test
    void studentBorrowerLoanPeriodCorrect() {
        assertEquals(21, student.loanPeriodDays());
    }

    @Test
    void studentBorrowerRoleCorrect() {
        assertEquals("Student Borrower", student.role());
    }

    @Test
    void studentBorrowerStudentNumberCorrect() {
        assertEquals("STU12345", student.studentNumber());
    }

    @Test
    void studentBorrowerToStringContainsStudentNumber() {
        assertTrue(student.toString().contains("STU12345"),
                "StudentBorrower toString() should include the student number");
    }

    @Test
    void borrowingLimitsAreDistinctAcrossTypes() {
        assertNotEquals(RegularBorrower.MAX_BOOKS, PremiumBorrower.MAX_BOOKS);
        assertNotEquals(RegularBorrower.MAX_BOOKS, StudentBorrower.MAX_BOOKS);
        assertNotEquals(PremiumBorrower.MAX_BOOKS, StudentBorrower.MAX_BOOKS);
    }
}
