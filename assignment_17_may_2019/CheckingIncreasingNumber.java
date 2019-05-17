import java.util.Scanner;
import java.util.Arrays;
class CheckingIncreasingNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int number = sc.nextInt();
		boolean flag = new CheckingIncreasingNumber().checkNumber(number);
		if (flag == true) {
			System.out.println("Increasing Number!");
		} else {
			System.out.println("Non Increasing Number!");
		}
	}

	boolean checkNumber(int number){
		String numStr = String.valueOf(number);
		boolean flag = false;
		String[] strArr = numStr.split("");
		Arrays.sort(strArr);
		String sortedArr = "";
		for (int i = 0; i < strArr.length ; i++) {
			sortedArr += strArr[i];
		}

		if (numStr.equals(sortedArr)) {
			flag = true;
		}
		
		return flag;
	}
}