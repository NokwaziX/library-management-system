package com.nokwazi.library.model;

public abstract class Borrower extends Person {

    private final String borrowerId;
    private boolean active;

    public Borrower(String firstName, String lastName, String email, String phoneNumber, String borrowerId) {
        super(firstName, lastName, email, phoneNumber);
        this.borrowerId = borrowerId;
        this.active = true;
    }

    public String borrowerId() {return borrowerId;}
    public boolean isActive() {return active;}

    public void makeActive(boolean active) {
        this.active = active;
    }


    @Override
    public String role(){
        return "Borrower";
    }

    @Override
    public String toString() {
        return  super.toString() + ", Borrower ID: " + borrowerId;
    }

    public abstract int borrowingLimit();
    public abstract int loanPeriodDays();

}
