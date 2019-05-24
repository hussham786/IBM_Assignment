package com.ibm.pwa.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ibm.pwa.bean.Customer;
import com.ibm.pwa.bean.Transaction;
import com.ibm.pwa.bean.TransactionHistory;
import com.ibm.pwa.service.PaymentWalletService;
import com.ibm.pwa.service.PaymentWalletServiceClass;

public class PaymentWalletMain {
	static PaymentWalletService service;
	static Scanner sc;
	static Transaction transaction;
	static Customer customer;

	public static void main(String[] args) {
		PaymentWalletMain.service = new PaymentWalletServiceClass();
		PaymentWalletMain.sc = new Scanner(System.in);
		PaymentWalletMain.transaction = new Transaction();
		PaymentWalletMain.customer = new Customer();
		if (service.connectToDb())
			new PaymentWalletMain().takeChoiceFromUser();
		else
			System.out.println("Some issues....");

	}

	private void takeChoiceFromUser() {
		String str = "";
		System.out.println("Welcome to Payment Wallet Application!");
		do {
			System.out.println(
					"Enter your choice\nEnter 1 to register\nEnter 2 to login as an existing customer");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				registerCust(); // registering new customer
				break;
			case 2:
				customerLogin(); // customer login
				break;

			default:
				System.out.println("Wrong Input");
				break;
			}
			System.out.println("Do you want to continue\nPress y/n");
			str = sc.next();
		} while (str.equalsIgnoreCase("Y"));
		System.out.println("Thank You for using the app!!!!");
	}

	private void customerLogin() {
		while(true) {
		System.out.println("Enter your cust Id");
		int custId = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter your password");
		String password = sc.nextLine();

		if (service.custLogin(custId, password)) {
			customerTransaction(custId);
			break;
		} else {
			System.out.println("Entered Id and password is not valid");
		}
		}

	}

	private void customerTransaction(int custId) {
		boolean flag = false;
		List<TransactionHistory> histories = new ArrayList<>();
		int choice = 0;
		if (!service.checkId(custId)) {
			flag = service.customerTransaction(custId);
		}
		/* if (flag == true) { */
		do {
			System.out.println("Enter your choice\nEnter 1 to check balance\nEnter 2 to add money into wallet\n"
					+ "Enter 3 to withdraw from wallet\nEnter 4 for fund transfer\nEnter 5 to Generate transaction slip\nEnter 6 to log out");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				checkAccntBalance(custId); // creating transaction
				break;
			case 2:
				addMoneyToWallet(custId); // adding money to wallet
				break;
			case 3:
				withdrawFromWallet(custId); // withdraw from wallet
				break;
			case 4:
				fundTransfer(custId); // transferring funds
				break;
			case 5:
				histories = service.printTransactionSlip(custId);
				for (TransactionHistory transactionHistory : histories) {
					System.out.println("UID : " + transactionHistory.getUID().trim().split("\\.")[0]);
					System.out.println("Type : " + transactionHistory.getTypeOfTransaction());
					if (transactionHistory.getTypeOfTransaction().equals("Fund Transfer")) {
						System.out.println("From : " + service.welComeUser(transactionHistory.getFrom())
								+ " transferred " + transactionHistory.getTransactionAmount() + " to : "
								+ service.welComeUser(transactionHistory.getTo()));
					} else if(transactionHistory.getTypeOfTransaction().equals("Self Deposit")){
						System.out.println("You deposited "+transactionHistory.getTransactionAmount()+" in your wallet");
					} else {
						System.out.println("You withdrawn "+transactionHistory.getTransactionAmount()+" from your wallet");
					}
					System.out.println("Transferred Date : " + transactionHistory.getTransactionDate() + "\n");
				}
				break;
			case 6:
				System.out.println("Successfully logged out");
				break;
			default:
				System.out.println("Wrong Input");
			}
		} while (choice < 6);
		/* } */

	}

	private void checkAccntBalance(int custId) {
		System.out.println("Current Account Balance is = " + service.checkBalance(custId));

	}

	private void fundTransfer(int custId) {
		System.out.println("Enter customer Id to transfer");
		int receiverId = sc.nextInt();

		System.out.println("Enter the amount to transfer");
		double balance = sc.nextDouble();

		System.out.println(service.transferFunds(custId, receiverId, balance));
		List<TransactionHistory> list = service.transactionHistory(custId, receiverId, balance, "Fund Transfer");
		for (TransactionHistory transactionHistory : list) {
			System.out.println("Generated UID : " + transactionHistory.getUID().trim().split("\\.")[0]);
		}
		
		

	}

	private void withdrawFromWallet(int custId) {
		System.out.println("Enter the amount to withdraw");
		double balance = sc.nextDouble();
		System.out.println(service.withdrawAmt(custId, balance));
		List<TransactionHistory> list = service.transactionHistory(custId, custId, balance, "Self Withdraw");
		for (TransactionHistory transactionHistory : list) {
			System.out.println("Generated UID : " + transactionHistory.getUID().trim().split("\\.")[0]);
		}
	}

	private void addMoneyToWallet(int custId) {
		System.out.println("Enter the amount to add");
		double balance = sc.nextDouble();
		System.out.println(service.depositAmt(custId, balance));
		List<TransactionHistory> list = service.transactionHistory(custId, custId, balance, "Self Deposit");
		for (TransactionHistory transactionHistory : list) {
			System.out.println("Generated UID : " + transactionHistory.getUID().trim().split("\\.")[0]);
		}
	}


	private void registerCust() {
		System.out.println("Enter the name of customer");
		String custName = sc.nextLine();

		System.out.println("Enter a password");
		String password = sc.nextLine();

		System.out.println("Enter the address of customer");
		String custAddress = sc.nextLine();

		System.out.println("Enter the DOB of customer");
		String DOB = sc.nextLine();

		customer.setCustName(custName);
		customer.setPassword(password);
		customer.setCustAddress(custAddress);
		customer.setDOB(DOB);

		System.out.println(service.insertCustDetails(customer));

	}

}
