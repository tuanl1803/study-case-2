package com.mitrais.studycase1.atm.view;

import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.model.Transfer;
import com.mitrais.studycase1.atm.service.FundTransferService;
import com.mitrais.studycase1.atm.service.FundTransferServiceImpl;

public class FundTransferScreen4 {

    public void show(Transfer transfer) {

        FundTransferService fundTransferService = new FundTransferServiceImpl();
        FundTransferScreen1 fundTransferScreen = new FundTransferScreen1();

        System.out.println();
        System.out.println("Transfer Confirmation");
        System.out.println("Destination Account: " + transfer.getDesAccount().getAccountNumber());
        System.out.println("Transfer Amount: $" + transfer.getAmount());
        System.out.println("Reference Number: " + transfer.getReferenceNumber());

        System.out.println("1. Confirm Trx");
        System.out.println("2. Cancel Trx");

        fundTransferService.transferConfirmScreen(fundTransferScreen, transfer);
    }

}
