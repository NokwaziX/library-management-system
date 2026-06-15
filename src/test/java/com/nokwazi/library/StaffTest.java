package com.nokwazi.library;

import com.nokwazi.library.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
    private Librarian         librarian;
    private LibraryAssistant  assistant;

    @BeforeEach
    void setUp() {
        librarian = new Librarian("Dave", "Sithole", "dave@library.com", "071 000 0004",
                "E001", 4, "Archives", "BLIS Degree");
        assistant = new LibraryAssistant("Eve", "Khumalo", "eve@library.com", "071 000 0005",
                "E002", 2, "Fiction");
    }

    @Test
    void staffIsSubclassOfPerson() {
        assertInstanceOf(Person.class, librarian);
        assertInstanceOf(Person.class, assistant);
    }

    @Test
    void employeeIdReturnsCorrectId() {
        assertEquals("E001", librarian.employeeId());
        assertEquals("E002", assistant.employeeId());
    }

    @Test
    void yearsOfServiceReturnsCorrectValue() {
        assertEquals(4, librarian.yearsOfService());
        assertEquals(2, assistant.yearsOfService());
    }

    @Test
    void updateYearsOfServiceUpdatesValue() {
        librarian.updateYearsOfService(6);
        assertEquals(6, librarian.yearsOfService());
    }

    @Test
    void updateYearsOfServiceThrowsForNegativeValue() {
        assertThrows(IllegalArgumentException.class,
                () -> librarian.updateYearsOfService(-1));
    }

    @Test
    void updateYearsOfServiceAllowsZero() {
        assertDoesNotThrow(() -> assistant.updateYearsOfService(0));
        assertEquals(0, assistant.yearsOfService());
    }

    @Test
    void staffToStringContainsEmployeeId() {
        assertTrue(librarian.toString().contains("E001"),
                "Staff toString() should include the employee ID");
    }

    @Test
    void librarianIsSubclassOfStaff() {
        assertInstanceOf(Staff.class, librarian);
    }

    @Test
    void librarianMonthlySalaryIncludesYearsOfServiceBonus() {
        double expected = Librarian.BASE_SALARY + (4 * Librarian.SALARY_PER_YEAR);
        assertEquals(expected, librarian.monthlySalary(), 0.001);
    }

    @Test
    void librarianMonthlySalaryUpdatesWithYearsOfService() {
        librarian.updateYearsOfService(10);
        double expected = Librarian.BASE_SALARY + (10 * Librarian.SALARY_PER_YEAR);
        assertEquals(expected, librarian.monthlySalary(), 0.001);
    }

    @Test
    void librarianDutiesCorrect() {
        assertEquals("Cataloguing, reference assistance, and collection management",
                librarian.duties());
    }

    @Test
    void librarianRoleIncludesSpecialisation() {
        assertEquals("Librarian (Archives)", librarian.role());
    }

    @Test
    void librarianSpecialisationCorrect() {
        assertEquals("Archives", librarian.specialisation());
    }

    @Test
    void librarianUpdateSpecialisationUpdatesRole() {
        librarian.updateSpecialisation("Digital Resources");
        assertEquals("Digital Resources", librarian.specialisation());
        assertEquals("Librarian (Digital Resources)", librarian.role());
    }

    @Test
    void librarianQualificationCorrect() {
        assertEquals("BLIS Degree", librarian.qualification());
    }

    @Test
    void librarianToStringContainsSpecialisationAndQualification() {
        String result = librarian.toString();
        assertTrue(result.contains("Archives"),    "toString() should contain specialisation");
        assertTrue(result.contains("BLIS Degree"), "toString() should contain qualification");
    }

    @Test
    void assistantIsSubclassOfStaff() {
        assertInstanceOf(Staff.class, assistant);
    }

    @Test
    void assistantMonthlySalaryIsFixed() {
        assertEquals(LibraryAssistant.MONTHLY_SALARY, assistant.monthlySalary(), 0.001);
    }

    @Test
    void assistantMonthlySalaryDoesNotChangeWithYearsOfService() {
        assistant.updateYearsOfService(10);
        assertEquals(LibraryAssistant.MONTHLY_SALARY, assistant.monthlySalary(), 0.001);
    }

    @Test
    void assistantDutiesCorrect() {
        assertEquals("Shelving books, member check-in, and issue desk", assistant.duties());
    }

    @Test
    void assistantRoleIncludesSection() {
        assertEquals("Library Assistant (Fiction section)", assistant.role());
    }

    @Test
    void assistantSectionCorrect() {
        assertEquals("Fiction", assistant.section());
    }

    @Test
    void assistantUpdateSectionUpdatesRole() {
        assistant.updateSection("Non-Fiction");
        assertEquals("Non-Fiction", assistant.section());
        assertEquals("Library Assistant (Non-Fiction section)", assistant.role());
    }

    @Test
    void assistantToStringContainsSection() {
        assertTrue(assistant.toString().contains("Fiction"),
                "LibraryAssistant toString() should mention the section");
    }

    @Test
    void salariesAreDifferentAcrossTypes() {
        assertNotEquals(librarian.monthlySalary(), assistant.monthlySalary());
    }
}
