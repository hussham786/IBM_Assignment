import java.util.Scanner;
class PalindromeStringCheck{
	public static void main(String[] args) {
		String str = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		str = sc.nextLine();
		boolean pal = new PalindromeStringCheck().palindromeCheck(str);

		if(pal == true){
			System.out.println("Entered string is palindrome");
		} else {
			System.out.println("Entered string is not palindrome");
		}
		
	}

	boolean palindromeCheck(String str){
		boolean pal = false;
		String reverseStr = "";
		for (int i = str.length() - 1; i >= 0 ; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}

		if(reverseStr.equals(str)){
			pal = true;
		} else {
			pal = false;
		}

		return pal;
	}
}