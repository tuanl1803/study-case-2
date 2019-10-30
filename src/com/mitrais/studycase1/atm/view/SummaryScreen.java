package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class SummaryScreen {

    public void show(Account account , int amount) {

        TransactionScreen ts = new TransactionScreen();
        WelcomeScreen ws = new WelcomeScreen();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("Summary Screen");
        System.out.println("----------------");
        System.out.println("Date : " + dtf.format(now));
        System.out.println("Withdraw: $" + amount);
        System.out.println("Balance: $" + account.getBalance());

        System.out.println("1. Transfer");
        System.out.println("2. Exit");

        int opt = scan.nextInt();
        switch (opt) {
            case 1:
                ts.show(account);
                break;
            case 2:
                ws.show();
                break;
            default:
                System.out.println("default");
                break;
        }
    }
}
