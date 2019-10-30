package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.WithdrawServices;
import com.mitrais.studycase1.atm.service.WithdrawServicesImpl;

import java.util.Scanner;

public class WithdrawScreen {
	public void show(Account account) {

		System.out.println();
		System.out.println("Withdraw Screen");
		System.out.println("----------------");
		System.out.println("1. $10");
		System.out.println("2. $50");
		System.out.println("3. $100");
		System.out.println("4. Other");
		System.out.println("5. Back");

		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();
		SummaryScreen summaryScreen = new SummaryScreen();
		TransactionScreen transactionScreen = new TransactionScreen();
		OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
		WithdrawServices withdrawServices = new WithdrawServicesImpl();

		switch (opt) {
			case "1":
				withdrawServices.caculateWithdrawAmount(account, summaryScreen, transactionScreen, 10);
				break;
			case "2":
				withdrawServices.caculateWithdrawAmount(account, summaryScreen, transactionScreen, 50);
				break;
			case "3":
				withdrawServices.caculateWithdrawAmount(account, summaryScreen, transactionScreen, 100);
				break;
			case "4":
				otherWithdrawScreen.show(account);
				break;
			case "5":
			case "":
			default:
				transactionScreen.show(account);
				break;
		}
	}
}
