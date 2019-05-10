import java.util.Scanner;
class RemoveDuplicateCharInString{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();

		System.out.println("The string after removing duplicate is: " + new RemoveDuplicateCharInString().removeDupChar(str));
	}

	String removeDupChar(String str){
		String result = "";
	    for (int i = 0; i < str.length(); i++) {
	        if(!result.contains(String.valueOf(str.charAt(i)))) {
	            result += String.valueOf(str.charAt(i));
	        }
	    }
	    return result;
	}
}