package com.ibm.eis.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.ibm.eis.bean.Employee;

public class DaoClass implements DaoInterface {
	private Map<Integer,Employee> employees=new 
			HashMap<Integer,Employee>();
	@Override
	public String getInsuranceSchemeBasedOnSalaryAndDesignation(Employee employee) {
		// TODO Auto-generated method stub
		String insurance = "";
		if(employee.getSalary() > 5000 && employee.getSalary() < 20000 && employee.getDesignation().equals("System Associate")) {
			insurance = "Scheme C";
		} else if(employee.getSalary() >= 20000 && employee.getSalary() < 40000 && employee.getDesignation().equals("Programmer")) {
			insurance = "Scheme B";
		} else if(employee.getSalary() >= 40000 && employee.getDesignation().equals("Manager")) {
			insurance = "Scheme A";
		} else if(employee.getSalary() < 5000 && employee.getDesignation().equals("Clerk")){
			insurance = "No Scheme";
		} else {
			insurance = "No valid Scheme";
		}
		
		return insurance;
	}

	@Override
	public Employee getInsuranceSchemeBasedOnIdAndName(int id, String name) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		for (Entry<Integer, Employee> entry : employees.entrySet()) {
		    int hashId = entry.getKey(); 
		    if(id == hashId && entry.getValue().getName().equals(name)) {
		    	emp = entry.getValue();
		    	break;
		    } else {
		    	emp = null;
		    }
		    
		}
		return emp;
	}

	@Override
	public void storeIntoMap(Employee employee) {
		// TODO Auto-generated method stub
		employees.put(employee.getId(), employee);
	}

	@Override
	public boolean isExists(int id) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if(employees != null) {
			if(employees.containsKey(id))
				bool = true;
			else
				bool = false;
		}
		
		return bool;
	}

	@Override
	public Map<Integer, Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return employees;
	}

}
