class CommandLineAdd{
	public static void main(String[] args) {
		
			System.out.println("1st num: " + args[0]);
			System.out.println("2nd num: " + args[1]);
			System.out.println("3rd num: " + args[2]);
			System.out.println("4th num: " + args[3]);
		
		System.out.println("The sum is: " + new CommandLineAdd().addNum(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])));
		
	}

	int addNum(int num1, int num2, int num3, int num4){
		return num1 + num2 + num3 + num4;
	}
}