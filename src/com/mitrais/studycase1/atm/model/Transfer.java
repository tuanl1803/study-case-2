package com.mitrais.studycase1.atm.model;

import java.util.Date;

public class Transfer {
    private Account fromAccount;
    private Account desAccount;
    private int amount;
    private int referenceNumber;
    private Date time;

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getDesAccount() {
        return desAccount;
    }

    public void setDesAccount(Account desAccount) {
        this.desAccount = desAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Transfer(Account fromAccount, Account desAccount, int amount, int referenceNumber, Date time) {
        this.fromAccount = fromAccount;
        this.desAccount = desAccount;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.time = time;
    }
}
