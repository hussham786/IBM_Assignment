import java.util.Scanner;
import java.util.Arrays;
class SecondSmallestInteger{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the limit");
		int lim = sc.nextInt();
		int[] numArr = new int[lim];
		System.out.println("Enter the numbers");
		for (int i = 0; i < lim ; i++) {
			numArr[i] = sc.nextInt();
		}
		System.out.println("Second smallest number : " + new SecondSmallestInteger().getSecondSmallest(numArr));
	}

	int getSecondSmallest(int numArr[]){
		Arrays.sort(numArr);
		return numArr[1];
	}
}