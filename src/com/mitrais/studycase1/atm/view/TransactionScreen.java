package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;

import java.util.List;
import java.util.Scanner;

public class TransactionScreen {

    public void show(Account account) {

        WithdrawScreen withdrawScreen = new WithdrawScreen();
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        FundTransferScreen1 fundTransferScreen = new FundTransferScreen1();
        TransactionHistoryScreen historyScreen = new TransactionHistoryScreen();

        System.out.println();
        System.out.println("Transfer Screen");
        System.out.println("----------------");

        System.out.println("1. Withdraw ");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Show 10 last Transactions");
        System.out.println("4. Exit ");

        Scanner scan = new Scanner(System.in);
        String opt = scan.nextLine();

        switch (opt) {

            case "1":
                withdrawScreen.show(account);
                break;
            case "2":
                fundTransferScreen.show(account);
                break;
            case "3":
                historyScreen.show(account);
                show(account);
                break;
            case "4":
            case "":
                welcomeScreen.show();
                break;
            default:
                show(account);
                break;
        }

    }

}
