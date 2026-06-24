package com.nokwazi.library.service;

import com.nokwazi.library.model.Borrower;
import com.nokwazi.library.model.Staff;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class LibraryManager {

    private final String libraryName;
    private List<Borrower> borrowers;
    private List<Staff> staffList;

    public LibraryManager(String libraryName) {
        this.libraryName = libraryName;
        this.borrowers = new ArrayList<>();
        this.staffList = new ArrayList<>();
    }

    public void addBorrower(Borrower borrower){
        borrowers.add(borrower);
    }

    public Borrower findBorrower(String borrowerId){
        for (Borrower borrower : borrowers) {
            if (borrower.borrowerId().equals(borrowerId)) {
                return borrower;
            }
        }
        return null;
    }

    public void removeBorrower(String borrowerId){
        Borrower borrowerFound = findBorrower(borrowerId);
        if (borrowerId == null) {
            throw new IllegalArgumentException("Borrower does not exist");
        }
        borrowers.remove(borrowerFound);
    }

    public List<Borrower> borrowers() { return Collections.unmodifiableList(borrowers); }
    public List<Borrower> activeBorrowers() {
        List<Borrower> activeBorrowers = new ArrayList<>();
        for (Borrower borrower : borrowers) {
            if (borrower.isActive()) {
                activeBorrowers.add(borrower);
            }
        }return activeBorrowers;
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public Staff findStaff(String employeeId) {
        for (Staff staff : staffList) {
            if (staff.employeeId().equals(employeeId)) {
                return staff;
            }
        }return null;
    }

    public List<Staff> staffList() { return Collections.unmodifiableList(staffList); }

}
