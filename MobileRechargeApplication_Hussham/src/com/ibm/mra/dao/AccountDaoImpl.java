package com.ibm.mra.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ibm.mra.beans.Account;

public class AccountDaoImpl implements AccountDao {
	Map<String, Account> accountEntry;
	Account account;

	public AccountDaoImpl() {
		accountEntry = new HashMap<>();
		//putting values in the hashmap
		accountEntry.put("9748132465", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("7278763184", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210131", new Account("Prepaid", "Tushar", 632));
	}

	@Override
	public Account getAccountDetails(String mobileNo) {
		for (Entry<String, Account> entry : accountEntry.entrySet()) {
			if (mobileNo.equals(entry.getKey())) {
				//retrieving account details where given mobile number matches the key
				account = new Account(entry.getValue().getAccountType(), entry.getValue().getCustomerName(),
						entry.getValue().getAccountBalance());
				break;
			}

		}

		return account;
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		int updatedBalance = 0;
		for (Entry<String, Account> entry : accountEntry.entrySet()) {
			if (mobileNo.equals(entry.getKey())) {
				updatedBalance = (int) ((int)entry.getValue().getAccountBalance() + rechargeAmount);
				entry.setValue(new Account(entry.getValue().getAccountType(), entry.getValue().getCustomerName(),
						updatedBalance));
				break;
			}

		}
		return updatedBalance;
	}
	
	@Override
	public boolean isExists(String mobileNo) {
		boolean bool = false;
		if(accountEntry != null) {
			if(accountEntry.containsKey(mobileNo))
				bool = true;
			else
				bool = false;
		}
		
		return bool;
	}

}
