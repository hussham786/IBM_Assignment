import java.util.Scanner;
class SumOfNumbersDivisibilityCheck{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range");
		int n = sc.nextInt();
		System.out.println("Sum is : " + new SumOfNumbersDivisibilityCheck().calculateSum(n));
	}

	int calculateSum(int n){
		int sum = 0;
		for (int i = 1; i <= n ; i++) {
			if((i % 3) == 0 || (i % 5) == 0){
				System.out.print(i +" ");
				sum = sum + i;
			}
		}
		return sum;
	}
}