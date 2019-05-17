import java.util.Scanner;
class DifferenceOfSumOfSquares{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range");
		int n = sc.nextInt();
		System.out.println("Difference is : " + new DifferenceOfSumOfSquares().calculateDifference(n));
	}

	int calculateDifference(int n){
		int sum = 0, diff = 0, numSqr = 0;
		numSqr = 0;
		for (int i = 1; i <= n ; i++ ) {
			numSqr = numSqr + (i*i);
			sum = sum + i;
		}
		if(numSqr != (sum*sum)){
			if (numSqr > (sum*sum)) {
				diff = numSqr - (sum*sum);
			} else {
				diff = (sum*sum) - numSqr;
			}
			
		} else {
			diff = 0;
		}

		return diff;

	}
}