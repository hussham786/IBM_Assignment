package com.ibm.mra.service;

import com.ibm.mra.beans.Account;
import com.ibm.mra.exceptions.MyException;

public interface AccountService {
	Account getAccountDetails(String mobileNo);
	int rechargeAccount(String mobileNo, double rechargeAmount);
	boolean isExists(String mobileNo);
	boolean checkValidNumber(String mobileNo) throws MyException;
	boolean checkRechargeAmount(double rechargeAmount) throws MyException;
}
