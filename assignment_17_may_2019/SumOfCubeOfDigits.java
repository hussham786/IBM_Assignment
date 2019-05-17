import java.util.Scanner;
class SumOfCubeOfDigits{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		String num = sc.nextLine();
		System.out.println("Sum of cube of digits is : " + new SumOfCubeOfDigits().sumOfCubeOfDigits(num));
	}

	int sumOfCubeOfDigits(String num){
		String[] splitNum = num.split("");
		int sum = 0;
		for (String str : splitNum) {
			int cubeOfNum = Integer.parseInt(str) * Integer.parseInt(str) * Integer.parseInt(str);
			sum += cubeOfNum;
		}
		
		return sum;
	}
}