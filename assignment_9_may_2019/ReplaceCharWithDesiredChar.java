import java.util.Scanner;
class ReplaceCharWithDesiredChar{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();

		String repStr = "";
		for (int i = 0; i < str.length(); i++ ) {
			if(str.charAt(i) == 'r'){
				repStr = str.replace("r", "t");
			}
		}
		System.out.println("The Desired string is: " + repStr);
	}
}