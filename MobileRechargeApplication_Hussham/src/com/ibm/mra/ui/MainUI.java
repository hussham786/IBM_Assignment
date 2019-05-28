package com.ibm.mra.ui;

import java.util.Scanner;

import com.ibm.mra.exceptions.MyException;
import com.ibm.mra.service.AccountService;
import com.ibm.mra.service.AccountServiceImpl;

public class MainUI {
	static Scanner sc;
	static AccountService service;

	public static void main(String[] args) {
		MainUI.sc = new Scanner(System.in);
		MainUI.service = new AccountServiceImpl();
		new MainUI().displayMenu();
	}

	void displayMenu() {
		int choice = 0;
		do {
			System.out.println(
					"Enter your choice\nEnter 1 for Account Balance Enquiry\nEnter 2 to Recharge Account\nEnter 3 to Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				balanceEnquiry(); // calling balance enquiry
				break;
			case 2:
				rechargeAccount(); // calling recharge account
				break;
			case 3:
				System.out.println("Exit successfully!!");
				break;
			default:
				System.out.println("Wrong Input");
			}
		} while (choice < 3);
		System.out.println("Thank You for using the App");
	}

	private void rechargeAccount() {
		String mobileNo = "";
		int bal = 0;
		while (true)
			try {
				{
					System.out.println("Enter your mobile number");
					mobileNo = sc.nextLine();
					// checking if the number is valid
					try {
						if (service.checkValidNumber(mobileNo)) {
							// checking if the number exist
							if (service.isExists(mobileNo)) {
								break;
							} else {
								System.out.println("Cannot Recharge Account as Given Mobile No Does Not Exits");
							}
						}
					} catch (MyException e) {

						System.out.println(e);
					}
				}
			} catch (Exception e) {

				System.out.println("Some problems.....");
			}
		System.out.println("Enter Recharge Amount");
		double rechargeAmount = sc.nextDouble();
		try {
			if (service.checkRechargeAmount(rechargeAmount)) {
				bal = service.rechargeAccount(mobileNo, rechargeAmount);
			}
		} catch (MyException e) {

			System.out.println(e);
		}
		if (bal != 0) {
			System.out.println("Your Account Recharged Successfully!!");
			System.out.println(service.getAccountDetails(mobileNo));
		}

	}

	private void balanceEnquiry() {
		String mobileNo = "";
		while (true)
			try {
				{
					System.out.println("Enter your mobile number");
					mobileNo = sc.nextLine();
					try {
						// checking if the number is valid
						if (service.checkValidNumber(mobileNo)) {
							// checking if the number exist
							if (service.isExists(mobileNo)) {
								break;
							} else {
								System.out.println("Given Account Id Does Not Exits");
							}
						}
					} catch (MyException e) {
						System.out.println(e);
					}
				}
			} catch (Exception e) {

				System.out.println("Some problems...");
			}
		System.out.println(service.getAccountDetails(mobileNo));

	}

}