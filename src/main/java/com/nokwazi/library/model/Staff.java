package com.nokwazi.library.model;

public abstract class Staff extends Person{

    private final String employeeId;
    private int yearsOfService;

    public Staff(String firstName, String lastName, String email, String phoneNumber, String employeeId, int yearsOfService) {
        super(firstName, lastName, email, phoneNumber);
        this.employeeId = employeeId;
        updateYearsOfService(yearsOfService);
    }

    public String employeeId() {
        return employeeId;
    }
    public int yearsOfService() {
        return yearsOfService;
    }

    public void updateYearsOfService(int yearsOfService) {
        if (yearsOfService < 0) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        this.yearsOfService = yearsOfService;
    }

    @Override
    public String toString() {
        return super.toString() + "Employee ID: " + employeeId + ", Years Of Service: " + yearsOfService;
    }

    public abstract double monthlySalary();
    public abstract String duties();
}
