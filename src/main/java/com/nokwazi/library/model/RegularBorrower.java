package com.nokwazi.library.model;

public class RegularBorrower extends Borrower {

    public static final int MAX_BOOKS = 3;

    public RegularBorrower(String firstName, String lastName, String email, String phoneNumber, String borrowerId) {
        super(firstName, lastName, email, phoneNumber, borrowerId);
    }

    @Override
    public int borrowingLimit() {
        return MAX_BOOKS;
    }

    @Override
    public int loanPeriodDays() {
        return 14;
    }

    @Override
    public String role() {
        return "Regular Borrower";
    }

    @Override
    public String toString() {
        return super.toString() + " - Regular Borrower";
    }
}
