import java.util.Scanner;
import java.util.Arrays;
class CheckForPositiveString{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = sc.nextLine();
		boolean flag = new CheckForPositiveString().checkStr(str);
		if (flag == true) {
			System.out.println("Entered string is positive");
		} else {
			System.out.println("Entered string is not positive");
		}
	}

	boolean checkStr(String str){
		char sortedArray[] = str.toCharArray();
		Arrays.sort(sortedArray);
		String sortedStr = "";
		for (char sortStr : sortedArray) {
			sortedStr += sortStr;
		}
		if (str.equals(sortedStr)) {
			return true;
		} else {
			return false;
		}

	}
}