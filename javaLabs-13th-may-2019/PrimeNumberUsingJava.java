import java.util.Scanner;
class PrimeNumberUsingJava{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an Integer:");
		int num = sc.nextInt();
		new PrimeNumberUsingJava().prime(num);

	}

	void prime(int num){
		String primeNumbers = "";
		for (int i = 1; i<= num ;i++ ) {
			int counter=0; 
			for (int j = i; j >= 1 ; j-- ) {
				if (i % j == 0) {
					counter++;
				}
			}
			if (counter == 2)
	  		{
	     		primeNumbers = primeNumbers + i + " ";
	  		}
		}
		System.out.println("Prime Numbers upto " + num + " are " + primeNumbers);
	}
}