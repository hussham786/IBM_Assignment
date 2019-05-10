import java.util.Scanner;
class CheckEndOfString{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		System.out.println("Enter the end of string to match: ");
		String endStr = sc.nextLine();

		boolean bool = new CheckEndOfString().checkStringCompare(str, endStr);
		if (bool == true) {
			System.out.println("The given string ends with the end string");
		} else {
			System.out.println("The given string does not ends with the end string");
		}
	}

	boolean checkStringCompare(String str, String endStr){
		if (str.endsWith(endStr)) {
			return true;
		} else {
			return false;
		}
	}
}