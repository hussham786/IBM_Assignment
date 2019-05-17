import java.util.Scanner;
class JobSeekerApplicationValidation{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username : ");
		String valCheck = sc.nextLine();
		boolean flag = new JobSeekerApplicationValidation().checkValidation(valCheck);
		if (flag == true) {
			System.out.println("Valid Username!");
		} else {
			System.out.println("Username must end with _job and must contain atleast 8 characters to the left of _job!");
		}
	}

	boolean checkValidation(String valCheck){
		if (valCheck.endsWith("_job") && valCheck.length() >= 12) {
			return true;
		} else {
			return false;
		}
	}
}