package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.WithdrawServices;
import com.mitrais.studycase1.atm.service.WithdrawServicesImpl;

import java.util.Scanner;

public class OtherWithdrawScreen {

    public void show(Account account) {
        SummaryScreen summaryScreen = new SummaryScreen();
        WithdrawScreen withdrawScreen = new WithdrawScreen();
        WithdrawServices withdrawServices = new WithdrawServicesImpl();

        System.out.println();
        System.out.println("Other Withdraw Screen");
        System.out.println("--------------------");
        System.out.print("Enter amount to withdraw: ");
        Scanner scan = new Scanner(System.in);
        try {
            int amount = scan.nextInt();
            withdrawServices.validateAndCalculateWithdrawAmount(account, withdrawScreen, summaryScreen, amount);
        } catch (Exception e){
            System.out.println("Only Number Allowed");
        }

    }
}