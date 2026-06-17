//package com.nokwazi.library.service;
//
//import java.util.List;
//import java.util.ArrayList;
//
//
//public class LibraryManager {
//
//    private final String libraryName;
//    private List<Borrower> borrowers;
//    private List<Staff> staffList;
//
//    public LibraryManager(String libraryName) {
//        this.libraryName = libraryName;
//        this.borrowers = new ArrayList<>();
//        this.staffList = new ArrayList<>();
//    }
//
//    public void addBorrower(Borrower borrower){
//        borrowers.add(borrower);
//    }
//
//    public void removeBorrower(String borrowerId){
//        if (borrowerId == null) {
//            throw new IllegalArgumentException("Borrower does not exist");
//        }borrowers.remove(borrowerId);
//    }
//
//
//}
