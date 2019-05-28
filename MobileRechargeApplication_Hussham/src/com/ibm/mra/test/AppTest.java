package com.ibm.mra.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.ibm.mra.service.AccountService;
import com.ibm.mra.service.AccountServiceImpl;

public class AppTest {
	@ParameterizedTest
	@CsvSource(value = { "9748132465,20", "8981529535,300", "7003023347,30", "7278763184,50", "9992922134,40" })
	void testRechargeAccount(String mobileNo, double rechargeAmount) {
		AccountService service = new AccountServiceImpl();
		assertEquals(571, service.rechargeAccount(mobileNo, rechargeAmount));
	}

}
