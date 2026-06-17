package com.nokwazi.library.model;

public class LibraryAssistant extends Staff {

    public static final double MONTHLY_SALARY = 10_000.00;


    private String section;

    public LibraryAssistant(String firstName, String lastName, String email, String phoneNumber, String employeeId, int yearsOfService, String section) {
        super(firstName, lastName, email, phoneNumber, employeeId, yearsOfService);
        this.section = section;
    }

    public String section() {
        return section;
    }

    public void updateSection(String section) {
        this.section = section;
    }

    @Override
    public double monthlySalary() {
        return MONTHLY_SALARY;
    }

    @Override
    public String duties() {
        return "Shelving books, member check-in, and issue desk";
    }

    @Override
    public String role() {
        return "Library Assistant (" + section + " section)";
    }

    @Override
    public String toString() {
        return super.toString() + ", Section: " + section;
    }


}
