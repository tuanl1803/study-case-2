package com.mitrais.studycase1.atm.model;

public class Account {
    private String Name;
    private String PIN;
    private int Balance;
    private String accountNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account() {

    }

    public Account(String name, String PIN, int balance, String accountNumber) {
        Name = name;
        this.PIN = PIN;
        Balance = balance;
        this.accountNumber = accountNumber;
    }

}
