package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.TransactionScreen;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    @Override
    // Get balance for calculate and validate accNumber and PIN
    public void verifyAccount(String accountNumber, String pin) {
        TransactionScreen transactionScreen = new TransactionScreen();
        ReadCSV readCSV = new ReadCSVImpl();
        List<Account> accounts = readCSV.readRecord();
        int temp = 0;
        for (Account account : accounts) {
            if (accountNumber.equals(account.getAccountNumber()) && pin.equals(account.getPIN())) {
                temp = 0;
                transactionScreen.show(account);
                break;
            } else {
                temp = 1;
            }
        }
        if (temp == 1) {
            System.out.println("Invalid Account Number or PIN");
        }

    }

    @Override
    public boolean validateAccountNumber(String accountNumber) {
        String regex = "[0-9]+";
        int accLength = accountNumber.length();
        boolean tmp = true;
        if (accLength != 6) {
            System.out.println("Account Number should have 6 digits length");
            tmp = false;
        }
        if (!accountNumber.matches(regex)) {
            System.out.println("Account Number should only contains numbers");
            tmp = false;
        }
        return tmp;
    }

    @Override
    public boolean validatePinNumber(String pin) {
        String regex = "[0-9]+";
        int pinLength = pin.length();
        boolean tmp = true;
        if (pinLength != 6) {
            System.out.println("PIN should have 6 digits length");
            tmp = false;
        }
        if (!(pin.matches(regex))) {
            System.out.println("PIN should only contains numbers");
            tmp = false;
        }
        return tmp;
    }

    @Override
    public Account getAccountByNumber(String accNumber) {
        ReadCSV readCSV = new ReadCSVImpl();
        List<Account> accounts = readCSV.readRecord();
        for (Account account:
             accounts) {
            if(accNumber.equals(account.getAccountNumber())){
                return account;
            }

        }
        return null;
    }
}
