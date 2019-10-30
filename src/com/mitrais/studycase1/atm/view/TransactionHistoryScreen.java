package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.HistoryService;
import com.mitrais.studycase1.atm.service.HistoryServiceImpl;

public class TransactionHistoryScreen {
 
	public void show(Account account) {

		HistoryService historyService = new HistoryServiceImpl();

		System.out.println();
		System.out.println("Transaction History Screen");
		System.out.println("---------------------------");

		historyService.readWithdrawHistoryCSV(account);

		historyService.readTransferHistoryCSV(account);
	}
}
