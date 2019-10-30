package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVImpl implements ReadCSV {

	@Override
	public List<Account> readRecord() {
		try {
			String filepath = "accounts.csv";
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			List<String> data = new ArrayList<>();
			List<Account> accounts = new ArrayList<>();
			while (line != null) {

				data.add(line);

				String[] record = line.split("\\,");

				accounts.add(new Account(record[0], record[1], Integer.parseInt(record[2]), record[3]));
				line = reader.readLine();
			}
			reader.close();
			validateRecord(accounts);
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	

	@Override
	public void validateRecord(List<Account> accounts) {
		
		for (int i = 0; i < accounts.size() - 1; i++) {
			for (int j = i + 1; j < accounts.size(); j++) {
				if (accounts.get(i).getAccountNumber().equals(accounts.get(j).getAccountNumber()) && accounts.get(i).getBalance() == (accounts.get(j).getBalance())
						&& accounts.get(i).getName().equals(accounts.get(j).getName()) && accounts.get(i).getPIN().equals(accounts.get(j).getPIN())) {
					System.out.println("Can't have duplicated record in csv file");
					System.exit(0);
				}
				if (accounts.get(i).getAccountNumber().equals(accounts.get(j).getAccountNumber())) {
					System.out.println("Can't have 2 different account with the same Account Number in the csv file");
					System.exit(0);
				}
				
			}
		}
		
	}
}
