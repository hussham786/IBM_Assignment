package com.ibm.eis.service;

import java.util.Map;

import com.ibm.eis.bean.Employee;


public interface EmployeeService {
	String getInsuranceSchemeBasedOnSalaryAndDesignation(Employee employee);
	Employee getInsuranceSchemeBasedOnIdAndName(int id, String name);
	void storeIntoMap(Employee employee);
	boolean isExists(int id);
	Map<Integer,Employee> viewAllEmployee();
}
