import java.util.Scanner;
class CompareStringIgnoreCase{
	public static void main(String[] args) {
		String str1 = "", str2 = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first string: ");
		str1 = sc.nextLine();
		System.out.println("Enter second string: ");
		str2 = sc.nextLine();

		boolean strCheck = new CompareStringIgnoreCase().strCompare(str1, str2);
		if (strCheck == true) {
			System.out.println("Strings matched..");
		} else {
			System.out.println("Strings do not matched..");
		}
	}

	boolean strCompare(String str1, String str2){
		if(str1.equalsIgnoreCase(str2)){
			return true;
		} else {
			return false;
		}
	}
}