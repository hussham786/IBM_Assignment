import java.util.Scanner;
class FullNameInitials{
	public static void main(String[] args) {
		String str = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Full Name: ");
		str = sc.nextLine();

		System.out.println("Initials of your name is: " + new FullNameInitials().findInitials(str));
	}

	String findInitials(String str){
		String[] arr = str.split(" ");
		
		String initials = "";
		for (int i = 0; i < arr.length; i++) {
			//initials = initials + String.valueOf(arr[i]).charAt(0).toUpperCase();
			//System.out.println(i);
			initials = initials + arr[i].charAt(0);
			//System.out.println(arr[i]);
		}

		return initials;
	}
}