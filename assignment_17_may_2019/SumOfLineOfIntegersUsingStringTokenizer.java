import java.util.*;
class SumOfLineOfIntegersUsingStringTokenizer{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the series of integers");
		String numbers = sc.nextLine();
		System.out.println("The sum of the numbers is : " + new SumOfLineOfIntegersUsingStringTokenizer().sumDisplayNumUsingStringToken(numbers));
	}

	int sumDisplayNumUsingStringToken(String numbers){
		int sum = 0;
		System.out.println("numbers....." + numbers);
		StringTokenizer strToken = new StringTokenizer(numbers, " ");
		try{
			while (strToken.hasMoreTokens()) {
				int num = Integer.parseInt(strToken.nextToken());
	            System.out.println(num);
	            sum = sum + num;
			}
		} catch(Exception ex){
			System.out.println("No such element found" + ex);
		}
		return sum;
	

	}
}