package com.mitrais.studycase1.atm.view;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.service.FundTransferService;
import com.mitrais.studycase1.atm.service.FundTransferServiceImpl;

public class FundTransferScreen3 {

    public void show(Account account, Account desAccount, String transferAmount) {
        FundTransferService fundTransferService = new FundTransferServiceImpl();

        System.out.println();
        System.out.print("Please enter reference number (Optional) and \r\n" +
                "Press enter to continue or \r\n" +
                "Press cancel (Esc) to go back to Transfer: ");

        fundTransferService.inputReferenceNumberScreen(account, desAccount, transferAmount);
    }
}
