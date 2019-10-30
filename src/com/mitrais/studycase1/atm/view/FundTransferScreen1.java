package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferService;
import com.mitrais.studycase1.atm.service.FundTransferServiceImpl;

public class FundTransferScreen1 {

	FundTransferService fundTransferService = new FundTransferServiceImpl();

	public void show(Account account) {

		System.out.println();
		System.out.println("Fund Transfer Screen");
		System.out.println("----------------");
		System.out.println();
		System.out.print("Please enter destination account and \r\n" + 
				         "Press enter to continue or \r\n" + 
				         "Press cancel (Esc) to go back to Transfer: ");

		fundTransferService.inputDestinationAccount(account);
		
	}

}
