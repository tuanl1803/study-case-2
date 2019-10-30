package com.mitrais.studycase1.atm.service;

import com.mitrais.studycase1.atm.model.Account;

import java.util.List;

public interface ReadCSV {

    List<Account> readRecord();

    void validateRecord(List<Account> account);
}
