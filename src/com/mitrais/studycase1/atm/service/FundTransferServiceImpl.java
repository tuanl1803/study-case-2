package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.model.Transfer;
import com.mitrais.studycase1.atm.view.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FundTransferServiceImpl implements FundTransferService {

    @Override
    public void inputDestinationAccount(Account account) {

        String regex = "[0-9]+";
        FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
        FundTransferScreen1 transferScreen1 = new FundTransferScreen1();
        Scanner scan = new Scanner(System.in);
        String destinationNumber = scan.nextLine();

        if (!destinationNumber.matches(regex)) {
            System.out.println("Invalid account");
            transferScreen1.show(account);
        }

        if (isExists(destinationNumber)) {
            AccountService accountService = new AccountServiceImpl();
            Account desAccount = accountService.getAccountByNumber(destinationNumber);
            transferScreen2.show(account, desAccount);
        } else {
            System.out.println("Invalid account");
            transferScreen1.show(account);
        }
    }

    @Override
    public void inputAmountScreen(Account account, Account desAccount) {

        String regex = "\\d+";
        Scanner scan = new Scanner(System.in);
        FundTransferScreen3 transferScreen3 = new FundTransferScreen3();
        FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
        String transferAmount = scan.nextLine();

        if (!transferAmount.matches(regex)) {
            System.out.println("Invalid ammount");
            transferScreen2.show(account, desAccount);
        } else if (Integer.parseInt(transferAmount) > 1000) {
            System.out.println("Maximum amount to transfer is $1000");
            transferScreen2.show(account, desAccount);
        } else if (account.getBalance() - Integer.parseInt(transferAmount) < 0) {
            System.out.println("Insufficient balance $" + transferAmount);
            transferScreen2.show(account, desAccount);
        } else if (Integer.parseInt(transferAmount) < 1) {
            System.out.println("Minimum amount to transfer is $1");
        } else {
            transferScreen3.show(account, desAccount,transferAmount);
        }
    }

    @Override
    public void inputReferenceNumberScreen(Account account, Account desAccount, String transferAmount) {

        FundTransferScreen4 fundTransferScreen4 = new FundTransferScreen4();
        FundTransferScreen3 fundTransferScreen3 = new FundTransferScreen3();
        String regex = "[0-9]+";
        Scanner scan = new Scanner(System.in);
        String referenceNum = scan.nextLine();

        if (!referenceNum.matches(regex) && !referenceNum.isEmpty()) {
            System.out.println("Invalid Reference Number");
            fundTransferScreen3.show(account, desAccount, transferAmount);
        } else {
            Transfer transfer = new Transfer(account, desAccount, Integer.parseInt(transferAmount), Integer.parseInt(referenceNum), new Date());
            fundTransferScreen4.show(transfer);
        }

    }

    @Override
    public void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, Transfer transfer) {

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();
        Account curAccount = transfer.getFromAccount();
        Account desAccount = transfer.getDesAccount();
        switch (opt) {
            case "1":
                FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
                int curBalance = curAccount.getBalance();
                curAccount.setBalance(curBalance - transfer.getAmount());
                int desBalance = desAccount.getBalance();
                desAccount.setBalance(desBalance + transfer.getAmount());
                HistoryService historyService = new HistoryServiceImpl();
                historyService.addFundTransferHistory(transfer);
                fundTransferSummaryScreen.show(transfer);
                break;
            case "2":
                TransactionScreen transactionScreen = new TransactionScreen();
                transactionScreen.show(curAccount);
                break;
            case "":
                fundTransferScreen.show(curAccount);
                break;
            default:
                break;
        }
    }

    @Override
    public void transaction(TransactionScreen transactionScreen, Transfer transfer) {
        System.out.println("Transfer Succeed");
        transactionScreen.show(transfer.getFromAccount());

    }

    @Override
    public boolean isExists(String accountNumber) {
        boolean isExists = false;
        ReadCSV readCSV = new ReadCSVImpl();
        List<Account> accounts = readCSV.readRecord();
        for (Account account :
                accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                isExists = true;
                break;
            }

        }
        return isExists;
    }

}
