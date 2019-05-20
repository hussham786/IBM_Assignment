package com.ibm.eis.service;

import java.util.Map;
import com.ibm.eis.bean.Employee;
import com.ibm.eis.dao.DaoClass;

public class EmployeeServiceClass implements EmployeeService {
	DaoClass dao = new DaoClass();
	@Override
	public void storeIntoMap(Employee employee) {
		// TODO Auto-generated method stub
		
		dao.storeIntoMap(employee);
		

	}

	@Override
	public Map<Integer, Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return dao.viewAllEmployee();
	}

	@Override
	public String getInsuranceSchemeBasedOnSalaryAndDesignation(Employee employee) {
		// TODO Auto-generated method stub
		return dao.getInsuranceSchemeBasedOnSalaryAndDesignation(employee);
	}

	@Override
	public Employee getInsuranceSchemeBasedOnIdAndName(int id, String name) {
		// TODO Auto-generated method stub
		return dao.getInsuranceSchemeBasedOnIdAndName(id, name);	
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		return dao.isExists(id);
		
	}

}
