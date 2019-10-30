package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.SummaryScreen;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WithdrawScreen;

public class WithdrawServicesImpl implements WithdrawServices {

    @Override
    public void caculateWithdrawAmount(Account account,
                                       SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount) {

        if (account.getBalance() >= amount) {
            int temp = account.getBalance();
            account.setBalance(temp - amount);
            HistoryService historyService = new HistoryServiceImpl();
            historyService.addWithdrawHistory(account, amount);
            summaryScreen.show(account, amount);
        } else {
            System.out.println("Insufficient balance $" + amount);
            transactionScreen.show(account);
        }

    }

    @Override
    public void validateAndCalculateWithdrawAmount(Account account,
                                                   WithdrawScreen withdrawScreen, SummaryScreen summaryScreen, int amount) {
        if (amount % 10 != 0) {
            System.out.println("Invalid ammount");
            withdrawScreen.show(account);
        } else if (amount > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            withdrawScreen.show(account);
        } else if (account.getBalance() - amount < 0) {
            System.out.println("Insufficient balance $" + amount);
            withdrawScreen.show(account);
        } else {
            // calculate and set balance
            account.setBalance(account.getBalance() - amount);
            HistoryService historyService = new HistoryServiceImpl();
            historyService.addWithdrawHistory(account, amount);
            summaryScreen.show(account, amount);
        }

    }
}
