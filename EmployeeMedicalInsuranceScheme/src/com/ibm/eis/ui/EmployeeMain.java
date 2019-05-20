package com.ibm.eis.ui;

import java.util.Scanner;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.service.EmployeeService;
import com.ibm.eis.service.EmployeeServiceClass;

public class EmployeeMain {
	static Scanner sc;
	static EmployeeService service;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeMain.sc = new Scanner(System.in);
		EmployeeMain.service = new EmployeeServiceClass();
		String str = "";
		do {
		System.out.println("Enter your choice\nEnter 1 to enter details of employee\nEnter 2 to view all employees\nEnter 3 to see the insurance scheme based on salary and designation");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: new EmployeeMain().employeeDetails();
			break;
		case 2: System.out.println(service.viewAllEmployee());
			break;
		case 3: new EmployeeMain().insuranceSchemeGenerate();
			break;
		default: System.out.println("Wrong Input");
			break;
		}
		System.out.println("Do want to continue\nPress y/n");
		str = sc.next();
		} while(str.equalsIgnoreCase("Y"));
		
	}
	
	void employeeDetails() {
		Employee employee = new Employee();
		int empId = 0;
		while(true) {
		System.out.println("Enter the id");
		empId = sc.nextInt();
		sc.nextLine();
		if(!service.isExists(empId))
			break;
		else
			System.out.println("Employee already exists!");
		}
		
		System.out.println("Enter the name");
		String empName = sc.nextLine();
		System.out.println("Enter the salary");
		double empSal = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the designation : System Associate/Programmer/Manager/Clerk");
		String empDes = sc.nextLine();
		
		employee.setId(empId);
		employee.setName(empName);
		employee.setSalary(empSal);
		employee.setDesignation(empDes);
		employee.setInsuranceScheme(service.getInsuranceSchemeBasedOnSalaryAndDesignation(employee));
		
		service.storeIntoMap(employee);
	}
	
	void insuranceSchemeGenerate() {
		System.out.println("Enter the id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the name");
		String name = sc.nextLine();
		System.out.println(service.getInsuranceSchemeBasedOnIdAndName(id, name));
	}

}
