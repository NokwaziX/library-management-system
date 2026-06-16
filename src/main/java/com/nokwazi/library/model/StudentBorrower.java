package com.nokwazi.library.model;

public class StudentBorrower extends Borrower {

    public static final int MAX_BOOKS = 5;

    private final String studentNumber;

    public StudentBorrower(String firstName, String lastName, String email, String phoneNumber, String borrowerId, String studentNumber) {
        super(firstName, lastName, email, phoneNumber, borrowerId);
        this.studentNumber = studentNumber;
    }

    public String studentNumber() {
        return studentNumber;
    }

    @Override
    public int borrowingLimit() {
        return MAX_BOOKS;
    }
    @Override
    public int loanPeriodDays() {
        return 21;
    }
    @Override
    public String role() {
        return "Student Borrower";
    }
    @Override
    public String toString() {
        return super.toString() + " - Student Borrower";
    }
}
