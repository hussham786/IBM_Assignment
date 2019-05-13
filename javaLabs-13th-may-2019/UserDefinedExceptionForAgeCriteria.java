import java.util.Scanner;
class MyException extends Exception{
	 MyException(String s) { 
        super(s); 
    } 
}

class UserDefinedExceptionForAgeCriteria{
	public static void main(String[] args) throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Age");
		int age = sc.nextInt();

		if (age < 15) {
				//System.out.println("Inside if above throw");
				throw new MyException("Age must be above 15!");
			
		}
	}
}