package com.ibm.mra.service;

import com.ibm.mra.beans.Account;
import com.ibm.mra.dao.AccountDao;
import com.ibm.mra.dao.AccountDaoImpl;
import com.ibm.mra.exceptions.MyException;

public class AccountServiceImpl implements AccountService {
	AccountDao dao = new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo) {
		
		return dao.getAccountDetails(mobileNo);
	}

	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}

	@Override
	public boolean isExists(String mobileNo) {
		
		return dao.isExists(mobileNo);
	}

	@Override
	public boolean checkValidNumber(String mobileNo) throws MyException{
		boolean bool = false;
		if(mobileNo.length() == 10 && mobileNo != null) {
			bool = true;
		} else {
			throw new MyException("Invalid Number, it must be of 10 digits!!!!");
		}
		return bool;
	}

	@Override
	public boolean checkRechargeAmount(double rechargeAmount) throws MyException {
		boolean bool = false;
		if(rechargeAmount != 0.0) {
			bool = true;
		} else {
			throw new MyException("Please Enter some amount!!!!");
		}
		return bool;
	}

}
