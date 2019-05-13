import java.util.Scanner;
class FibonacciSeriesUsingJava{
	static int num1 = 1, num2 = 1, num3;
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter your choice\nEnter 1 for Recursive\nEnter 2 for Non Recursive");
		int num = sc.nextInt();
		System.out.println("Enter the range");
		int range = sc.nextInt();
		if (num == 1) {
		 	new FibonacciUsingJava().recursiveMet(range);
		 } else if(num == 2){
		 	new FibonacciUsingJava().nonRecursiveMet(range);
		 } else {
		 	System.out.println("Wrong Input");
		 }
	}

	 static void recursiveMet(int range){
		 if(range > 0){ 
		    System.out.print(num1+" "+num2); 
	         num3 = num1 + num2;    
	         num1 = num2;    
	         num2 = num3;    
	         System.out.print(" "+num3);   
	         recursiveMet(range-1);    
    	 } 
	}

	void nonRecursiveMet(int range){
		int num1 = 1, num2 = 1, num3;    
		 System.out.print(num1+" "+num2);  
		    
		 for(int i = 2; i < range; i++)  
		 {    
		  num3 = num1 + num2;    
		  System.out.print(" "+num3);    
		  num1 = num2;    
		  num2 = num3;    
		 }  
				
	}
}