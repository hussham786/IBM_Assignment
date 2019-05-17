import java.util.Scanner;
class CheckPowerOfTwo{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		boolean flag = new CheckPowerOfTwo().checkNumber(n);
		if (flag == true) {
			System.out.println("Entered number is power of 2!");
		} else {
			System.out.println("Entered number is not a power of 2!");
		}
	}

	boolean checkNumber(int n){
		if(n<=0){
		   return false;
		  }
		   
		  while(n > 1){
		   if(n % 2 != 0){
		    return false;
		   }
		   n = n / 2;
		  }
		  return true;
	}
}