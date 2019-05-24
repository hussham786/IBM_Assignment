package com.ibm.pwa.service;

import java.util.List;

import com.ibm.pwa.bean.Customer;
import com.ibm.pwa.bean.TransactionHistory;
import com.ibm.pwa.dao.DaoClass;

public class PaymentWalletServiceClass implements PaymentWalletService {
	DaoClass dao = new DaoClass();
	
	@Override
	public boolean connectToDb() {
		return dao.connectToDb();
		
	}

	@Override
	public Customer veiwAllCustomer() {
		return dao.veiwAllCustomer();

	}

	@Override
	public double checkBalance(int custId) {
		
		return dao.checkBalance(custId);
	}

	@Override
	public List<TransactionHistory> transactionHistory(int custId, int receiverId, double balance, String typeOfTransaction) {
		
		return dao.transactionHistory(custId, receiverId, balance, typeOfTransaction);
	}

	@Override
	public String insertCustDetails(Customer customer) {
		// TODO Auto-generated method stub
		return dao.insertCustDetails(customer);
	}

	@Override
	public String updateCustDetails(int custId) {
		// TODO Auto-generated method stub
		return dao.updateCustDetails(custId);
	}

	@Override
	public String deleteCustDetails(int custId) {
		// TODO Auto-generated method stub
		return dao.deleteCustDetails(custId);
	}

	@Override
	public boolean custLogin(int custId, String password) {
		// TODO Auto-generated method stub
		return dao.custLogin(custId, password);
	}

	@Override
	public boolean customerTransaction(int custId) {
		// TODO Auto-generated method stub
		return dao.customerTransaction(custId);
	}

	@Override
	public boolean checkId(int custId) {
		// TODO Auto-generated method stub
		return dao.checkId(custId);
	}

	@Override
	public String depositAmt(int custId, double balance) {
		
		return dao.depositAmt(custId, balance);
	}

	@Override
	public String withdrawAmt(int custId, double balance) {
		
		return dao.withdrawAmt(custId, balance);
	}

	@Override
	public String transferFunds(int custId, int receiverId, double balance) {
		double oldBalance = dao.checkBalance(custId);
		if(oldBalance > 0 && balance < oldBalance) {
			return dao.transferFunds(custId, receiverId, balance);
		} else {
			balance = 0;
			return dao.transferFunds(custId, receiverId, balance);
		}
		
	}

	@Override
	public String welComeUser(int custId) {
		
		return dao.welComeUser(custId);
	}

	@Override
	public List<TransactionHistory> printTransactionSlip(int custId) {
		// TODO Auto-generated method stub
		return dao.printTransactionSlip(custId);
	}

}
