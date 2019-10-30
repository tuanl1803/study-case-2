package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.model.Transfer;
import com.mitrais.studycase1.atm.view.FundTransferScreen1;
import com.mitrais.studycase1.atm.view.TransactionScreen;

public interface FundTransferService {

    // Fund Transfer Screen

    void inputDestinationAccount(Account account);

    void inputAmountScreen(Account account, Account desAccount);

    void inputReferenceNumberScreen(Account account, Account desAccount, String transferAmount);

    void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, Transfer transfer);

    //Fund Transfer Summary Screen

    void transaction(TransactionScreen transactionScreen, Transfer transfer);

    boolean isExists(String accountNumber);

}
