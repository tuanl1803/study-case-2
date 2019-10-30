package com.mitrais.studycase1.atm.service;


import com.mitrais.studycase1.atm.model.Account;
import com.mitrais.studycase1.atm.model.History;
import com.mitrais.studycase1.atm.model.Transfer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {

	@Override
	public void addWithdrawHistory(Account account, int amount) {

		try {
			FileWriter writer;
			writer = new FileWriter("WithdrawHistory.csv", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);

			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date curDate = new Date();
			String collect = "Withdraw History," + dtf.format(curDate) + "," + account.getAccountNumber() + ","
					+ amount + "," + "$" + account.getBalance();

			printWriter.print(collect);
			printWriter.append("\n");
			printWriter.flush();
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addFundTransferHistory(Transfer transfer) {

		try {
			FileWriter writer;
			writer = new FileWriter("FundTransferHistory.csv", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);

            SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date curDate = new Date();

			String collect = "Fund Transfer History," + dtf.format(curDate) + "," + transfer.getFromAccount().getAccountNumber() + ","
					+ transfer.getDesAccount().getAccountNumber() + "," + "$" + transfer.getAmount() + ","
					+ transfer.getReferenceNumber() + "," + "$" +  transfer.getFromAccount().getBalance();

			printWriter.print(collect);
			printWriter.append("\n");
			printWriter.flush();
			printWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void readWithdrawHistoryCSV(Account account) {

		History history = new History();

		try {
			String filepath = "WithdrawHistory.csv";
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			List<String> data = new ArrayList<>();
			while (line != null) {

				data.add(line);

				String[] record = line.split("\\,");

				if (account.getAccountNumber().equals(record[2])) {

					history.setType(record[0]);
					history.setDate(record[1]);
					history.setAccNumber(record[2]);
					history.setWithdrawAtm(record[3]);
					history.setBalance(record[4]);

					printWithdrawHistory(history);
				}

				line = reader.readLine();
			}
			reader.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void printWithdrawHistory(History history) {

		System.out.println(history.getType());
		System.out.println("Date: "+ history.getDate());
		System.out.println("Account Number: " + history.getAccNumber());
		System.out.println("Withdraw Amount: " + history.getWithdrawAtm());
		System.out.println("Balance: " + history.getBalance());
		System.out.println("=============================");

	}


	@Override
	public void readTransferHistoryCSV(Account account) {

		History history = new History();

		// Read WithdrawCSV
		try {
			String filepath = "FundTransferHistory.csv";
			File file = new File(filepath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			List<String> data = new ArrayList<>();
			while (line != null) {

				data.add(line);

				String[] record = line.split("\\,");

				if (account.getAccountNumber().equals(record[2])) {

					history.setType(record[0]);
					history.setDate(record[1]);
					history.setAccNumber(record[2]);
					history.setDestinationAcc(record[3]);
					history.setTransferAtm(record[4]);
					history.setRefNumber(record[5]);
					history.setBalance(record[6]);

					printTransferHistory(history);
				}

				line = reader.readLine();
			}
			reader.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void printTransferHistory(History history) {

		System.out.println(history.getType());
		System.out.println("Date: "+ history.getDate());
		System.out.println("Account Number: " + history.getAccNumber());
		System.out.println("Destination Account Number: " + history.getDestinationAcc());
		System.out.println("Transfer Amount: " + history.getTransferAtm());
		System.out.println("Reference Number: " + history.getRefNumber());
		System.out.println("Balance: " + history.getBalance());
		System.out.println("=============================");

	}

}
