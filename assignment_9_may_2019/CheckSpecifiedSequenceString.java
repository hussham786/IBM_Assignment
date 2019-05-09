import java.util.Scanner;
class CheckSpecifiedSequenceString{
	public static void main(String[] args) {
		String str = "", subStr = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first string: ");
		str = sc.nextLine();
		System.out.println("Enter string sequence: ");
		subStr = sc.nextLine();
		boolean br = new CheckSpecifiedSequenceString().checkSequence(str, subStr);
		if (br == true) {
			System.out.println("String sequence matched: ");
		} else {
			System.out.println("String sequence do not matched: ");
		}
	}

	boolean checkSequence(String str, String subStr){
		if(str.contains(subStr)){
			return true;
		} else {
			return false;
		}
	}
}
