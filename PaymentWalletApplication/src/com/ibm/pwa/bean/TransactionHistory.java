package com.ibm.pwa.bean;

import java.util.Date;
import java.util.List;

public class TransactionHistory {
	private int transactionHistoryId, from, to;
	private String typeOfTransaction;
	private double transactionAmount;
	private String UID;
	private Date transactionDate;
	public int getTransactionHistoryId() {
		return transactionHistoryId;
	}
	public void setTransactionHistoryId(int transactionHistoryId) {
		this.transactionHistoryId = transactionHistoryId;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}
	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
}
