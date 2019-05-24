package com.ibm.pwa.service;

import java.util.List;

import com.ibm.pwa.bean.Customer;
import com.ibm.pwa.bean.TransactionHistory;

public interface PaymentWalletService {
	boolean connectToDb();
	String insertCustDetails(Customer customer);
	String updateCustDetails(int custId);
	String deleteCustDetails(int custId);
	Customer veiwAllCustomer();
	double checkBalance(int custId);
	List<TransactionHistory> transactionHistory(int custId, int receiverId, double balance, String typeOfTransaction);
	boolean customerTransaction(int custId);
	boolean custLogin(int custId, String password);
	boolean checkId(int custId);
	String depositAmt(int custId, double balance);
	String withdrawAmt(int custId, double balance);
	String transferFunds(int custId, int receiverId, double balance);
	String welComeUser(int custId);
	List<TransactionHistory> printTransactionSlip(int custId);
}
