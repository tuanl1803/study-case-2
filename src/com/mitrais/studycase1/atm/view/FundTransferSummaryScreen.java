package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Transfer;
import com.mitrais.studycase1.atm.service.FundTransferService;
import com.mitrais.studycase1.atm.service.FundTransferServiceImpl;

import java.util.Scanner;

public class FundTransferSummaryScreen {

    public void show(Transfer transfer) {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        FundTransferService fundTransferService = new FundTransferServiceImpl();
        TransactionScreen transactionScreen = new TransactionScreen();
        System.out.println();
        System.out.println("Fund Transfer Summary Screen");
        System.out.println("----------------------");

        System.out.println("Destination Account: " + transfer.getDesAccount().getAccountNumber());
        System.out.println("Transfer Amount: $" + transfer.getAmount());
        System.out.println("Reference Number: " + transfer.getReferenceNumber());
        System.out.println("Balance: $" + transfer.getFromAccount().getBalance());

        System.out.println("1. Transfer");
        System.out.println("2. Exit");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {
            case "1":
                fundTransferService.transaction(transactionScreen, transfer);
                break;
            case "2":
            case "":
                welcomeScreen.show();
                break;
            default:
                show(transfer);
                break;
        }
    }
}
