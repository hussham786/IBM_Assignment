import java.util.Scanner;
import java.util.Arrays;
class ReverseIntegerArray{
	public static void main(String[] args) {
		
		//int[] numArrShow = new int[100];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the limit");
		int lim = sc.nextInt();
		int[] numArr = new int[lim];
		System.out.println("Enter the numbers");
		for (int i = 0; i < lim ; i++) {
			numArr[i] = sc.nextInt();
		}
		
		int[] sortedArr =  new ReverseIntegerArray().getSorted(numArr);
		System.out.println("Sorted Array : ");
		for (int sort: sortedArr) {
			System.out.print(sort + " ");
		}
		

	}

	int[] getSorted(int numArr[]){
		String[] strArr = new String[numArr.length];
		String str = "";
		String revStr = "";
		
		for (int i = 0; i < numArr.length ; i++) {
			strArr[i] = String.valueOf(numArr[i]);
			str = strArr[i];
			int strLen  = strArr[i].length();
			for (int j = strLen - 1; j >= 0 ; j-- ) {
				revStr = revStr + str.charAt(j);
				strArr[i] = revStr;
			}
			revStr = "";
			//System.out.print("length of single number : " + strLen);
			//System.out.print(strArr[i] + " ");
			//str = str + String.valueOf(numArr[i]);
		}
		Arrays.sort(strArr);
		int[] sortedArr = new int[numArr.length];
		for (int i = 0; i < numArr.length ; i++) {
			sortedArr[i] = Integer.parseInt(strArr[i]);
		}
		return sortedArr;
	}
}