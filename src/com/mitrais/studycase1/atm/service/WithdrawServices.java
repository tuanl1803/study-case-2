package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.view.SummaryScreen;
import com.mitrais.studycase1.atm.view.TransactionScreen;
import com.mitrais.studycase1.atm.view.WithdrawScreen;

public interface WithdrawServices {

    // Withdraw Screen
    void caculateWithdrawAmount(Account account, SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount);
    // Other Withdraw Screen

    void validateAndCalculateWithdrawAmount( Account account, WithdrawScreen withdrawScreen, SummaryScreen summaryScreen, int amount);
}
