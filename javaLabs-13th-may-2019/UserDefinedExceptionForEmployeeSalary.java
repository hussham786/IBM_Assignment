package com.cg.eis.exception;
import java.util.Scanner;
class EmployeeException extends Exception{
	 EmployeeException(String s) { 
        super(s); 
    } 
}

class UserDefinedExceptionForEmployeeSalary{
	public static void main(String[] args) throws EmployeeException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Salary");
		double salary = sc.nextDouble();

		if (salary < 3000) {
				//System.out.println("Inside if above throw");
				throw new EmployeeException("Salary is too low!");
			
		}
	}
}