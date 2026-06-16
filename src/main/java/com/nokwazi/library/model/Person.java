package com.nokwazi.library.model;

public abstract class Person {

    private final String firstName;
    private final String lastName;
    private String email;
    private String phoneNumber;

    public Person (String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public String firstName() { return firstName; }
    public String lastName() { return lastName; }
    public String email() { return email; }
    public String phoneNumber() { return phoneNumber;}

    public void addEmail(String email) {
        this.email = email;
    }
    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString(){
        return "Name: " + firstName + ", Surname: " + lastName + ", Email: " + email;
    }

    public abstract String role();


}
