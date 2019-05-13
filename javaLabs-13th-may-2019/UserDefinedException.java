import java.util.Scanner;
class MyException extends Exception{
	 MyException(String s) { 
        super(s); 
    } 
}

class UserDefinedException{
	public static void main(String[] args) throws MyException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name");
		String fName = sc.nextLine();
		System.out.println("Enter the last name");
		String lName = sc.nextLine();

		if (fName.isEmpty() || lName.isEmpty()) {
				//System.out.println("Inside if above throw");
				throw new MyException("Name cannot be blank");
			
		}
	}
}