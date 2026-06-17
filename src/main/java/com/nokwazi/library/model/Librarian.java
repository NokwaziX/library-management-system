package com.nokwazi.library.model;

public class Librarian extends Staff {

    public static final double BASE_SALARY = 22_000.00;
    public static final double SALARY_PER_YEAR = 600.00;


    private String specialisation;
    private final String qualification;

    public Librarian(String firstName, String lastName, String email, String phoneNumber, String employeeId, int yearsOfService, String specialisation, String qualification) {
        super(firstName, lastName, email, phoneNumber, employeeId, yearsOfService);
        this.qualification = qualification;
        this.specialisation = specialisation;
    }

    public String specialisation() {
        return specialisation;
    }
    public String qualification() {
        return qualification;
    }

    public void updateSpecialisation(String specialisation) {
        this.specialisation = specialisation;
        }

    @Override
    public double monthlySalary() {
        return BASE_SALARY + (yearsOfService() * SALARY_PER_YEAR);
    }

    @Override
    public String duties(){
        return "Cataloguing, reference assistance, and collection management";
    }

    @Override
    public String role(){
        return "Librarian (" + specialisation + ")";
    }

    @Override
    public String toString(){
        return super.toString() + ", Specialisation: " + specialisation + ", Qualification: " + qualification;
    }


}
