package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.model.History;
import com.mitrais.studycase1.atm.model.Transfer;

public interface HistoryService {
	
	public void addWithdrawHistory(Account account, int amount);
	
	public void addFundTransferHistory(Transfer transfer);
	
	public void readWithdrawHistoryCSV(Account account);
	
	public void printWithdrawHistory(History history);
	
	public void readTransferHistoryCSV(Account account);
	
	public void printTransferHistory(History history);
	
	
}
