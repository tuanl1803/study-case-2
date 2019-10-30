package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.service.AccountService;
import com.mitrais.studycase1.atm.service.AccountServiceImpl;

import java.util.Scanner;

public class WelcomeScreen {

	public void show() {
		// write your code here
		AccountService userService = new AccountServiceImpl();
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("Welcome Screen");
		System.out.println("---------------");
		System.out.print("Enter Account Number: ");
		String  accountNumber = scan.nextLine();
		userService.validateAccountNumber(accountNumber);
		System.out.print("Enter PIN: ");
		String pin = scan.nextLine();
		userService.validatePinNumber(pin);
		userService.verifyAccount(accountNumber, pin);

	}



}
