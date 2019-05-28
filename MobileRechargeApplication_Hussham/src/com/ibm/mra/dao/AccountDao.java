package com.ibm.mra.dao;

import com.ibm.mra.beans.Account;

public interface AccountDao {
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);
	boolean isExists(String mobileNo);
}
