import java.util.Scanner;
class TrafficLight{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Choice\nEnter 1 for Red\nEnter 2 for Yellow\nEnter 3 for Green");
		int choice = sc.nextInt();
		System.out.println(new TrafficLight().traffLight(choice));
	}

	String traffLight(int choice){
		String str = "";
		switch(choice){
			case 1: str = "STOP";
				break;
			case 2: str = "READY";
				break;
			case 3: str = "GO";
				break;
			default: str = "WRONG CHOICE";
		}
		return str;

	}
}