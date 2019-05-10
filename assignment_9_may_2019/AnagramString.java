import java.util.Scanner;
import java.util.Arrays;
class AnagramString{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String str = sc.nextLine();
		
		System.out.println("Enter the string to match: ");
		String matchStr = sc.nextLine();

		boolean br = new AnagramString().checkAnagram(str, matchStr);

		if (br == true) {
			System.out.println("Given String is anagram");
		} else {
			System.out.println("Given String is not an anagram");
		}
	}

	boolean checkAnagram(String str, String matchStr){
		String[] splitStr = str.split(" ");
		String joinStr = "";
		boolean check = true;
		for (int i = 0 ; i < splitStr.length ; i++ ) {
			joinStr = joinStr + splitStr[i];
		}
		if (joinStr.length() != matchStr.length()) {
			check = false;
		} else {
		 char[] arrStr = joinStr.toLowerCase().toCharArray();  
         char[] arrMatchStr = matchStr.toLowerCase().toCharArray();
         Arrays.sort(arrStr);
         Arrays.sort(arrMatchStr);
          check = Arrays.equals(arrStr, arrMatchStr);
     }

		if (check) {
			return true;
		} else {
			return false;
		}
	}
}