import java.util.Scanner;
class CharacterAtGivenIndexString{
	public static void main(String[] args) {
		String str = "";
		int index = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		str = sc.nextLine();
		System.out.println("Enter the index to search: ");
		index = sc.nextInt();
		System.out.println("The index value is: " + new CharacterAtGivenIndexString().charAtIndex(str, index));
	}

	char charAtIndex(String str, int index){
		return str.charAt(index);
	}
}