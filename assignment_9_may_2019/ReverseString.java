import java.util.Scanner;
class ReverseString{
	public static void main(String[] args) {
		String str = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		str = sc.nextLine();
		System.out.println("The reverse of the string is: " + new ReverseString().reverseString(str));
		
	}

	String reverseString(String str){
		String reverseStr = "";
		for (int i = str.length() - 1; i >= 0 ; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}

		return reverseStr;
	}
}