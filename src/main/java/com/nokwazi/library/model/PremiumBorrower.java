package com.nokwazi.library.model;

public class PremiumBorrower extends Borrower {

    public static final int MAX_BOOKS = 10;

    private boolean reservationsAllowed;

    public PremiumBorrower(String firstName, String lastName, String email, String phoneNumber, String borrowerId) {
        super(firstName, lastName, email, phoneNumber, borrowerId);
        this.reservationsAllowed = true;
    }

    public boolean isReservationsAllowed() {
        return reservationsAllowed;
    }

    public void setReservationsAllowed(boolean reservationsAllowed) {
        this.reservationsAllowed = reservationsAllowed;
    }

    @Override
    public int borrowingLimit() {
        return MAX_BOOKS;
    }
    @Override
    public int loanPeriodDays() {
        return 30;
    }
    @Override
    public String role() {
        return "Premium Borrower";
    }
    @Override
    public String toString() {
        return super.toString() + " - Premium Borrower";
    }
}
